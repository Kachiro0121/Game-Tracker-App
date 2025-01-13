package com.kachiro.game_catalog


import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.BaseFragment
import com.kachiro.base.adapter.ErrorItem
import com.kachiro.base.dp
import com.kachiro.core_api.dto.Game
import com.kachiro.game_catalog.adapter.GameItem
import com.kachiro.game_catalog.databinding.CatalogScreenBinding
import com.kachiro.game_catalog.databinding.DialogFilterBinding
import com.kachiro.game_catalog.di.CatalogComponent
import com.kachiro.game_catalog.dto.Filters
import com.kachiro.game_catalog.viewModels.CatalogViewModel
import com.kachiro.game_catalog.viewModels.CatalogViewModelFactory
import com.kachiro.game_catalog.viewModels.ResultState
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatalogFragment: BaseFragment<CatalogScreenBinding>() {

    companion object{
        fun newInstance() = CatalogFragment()
    }

    private val viewModel: CatalogViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: CatalogViewModelFactory

    @Inject
    lateinit var adapter: FastItemAdapter<GenericItem>

    private val itemDecorationVertical by lazy {
        MaterialDividerItemDecoration(requireContext(), VERTICAL).apply {
            dividerThickness = 16.dp
            dividerColor = Color.TRANSPARENT
        }
    }

    private val itemDecorationHorizontal by lazy {
        MaterialDividerItemDecoration(requireContext(), HORIZONTAL).apply {
            dividerThickness = 16.dp
            dividerColor = Color.TRANSPARENT
        }
    }

    override fun getViewBinding(): CatalogScreenBinding = CatalogScreenBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CatalogComponent.create(getAppComponent()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.catalog.apply {
            adapter = this@CatalogFragment.adapter
            addItemDecoration(itemDecorationVertical)
            addItemDecoration(itemDecorationHorizontal)
        }

        binding.filter.setOnClickListener {
            showFilterDialog2()
        }

        viewModel.stateList.observe(viewLifecycleOwner){ state ->
            when(state){
                is ResultState.Error -> showError(state.message)
                is ResultState.ErrorRes -> showError(state.message)
                is ResultState.Success<*> -> {
                    val items = state.model as List<Game>
                    val genericItems = items.map { GameItem(it) }
                    adapter.setNewList(genericItems)
                }
            }
        }

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED){

            }
        }

        adapter.onClickListener = { view, adapter, item, position ->
            when(item){
                is GameItem -> viewModel.openDetail(item.model.id)
            }
            false
        }


    }

    private fun showFilterDialog2() {
        val dialogView = DialogFilterBinding.inflate(layoutInflater)

        val genres = Filters.entries

        genres.forEach { genre ->
            val chip = Chip(context).apply {
                text = getString(genre.title)
                tag = genre
                isCheckable = true
                isChecked = viewModel.filters.value?.contains(genre) == true
            }
            dialogView.chipGroupGenres.addView(chip)
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.filter_options))
            .setView(dialogView.root)
            .setPositiveButton(R.string.apply) { dialog, _ ->
                val selectedGenres = dialogView.chipGroupGenres.checkedChipIds.map { id ->
                    dialogView.chipGroupGenres.findViewById<Chip>(id).tag as Filters
                }
                viewModel.applyFilter(selectedGenres)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.cancel() }
            .show()
    }

    private fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        adapter.setNewList(listOf(ErrorItem()))
    }

    private fun showError(@StringRes message: Int) {
        showError(getString(message))
    }

}