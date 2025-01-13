package com.kachiro.game

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.BaseFragment
import com.kachiro.base.adapter.ErrorItem
import com.kachiro.base.dp
import com.kachiro.game.adapter.GameCardRecommendItem
import com.kachiro.game.adapter.GroupItem
import com.kachiro.game.databinding.GameListBinding
import com.kachiro.game.di.GameListComponent
import com.kachiro.game.dto.GameCategory
import com.kachiro.game.viewModels.GameViewModel
import com.kachiro.game.viewModels.ResultGames
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import javax.inject.Inject

class GameListFragment : BaseFragment<GameListBinding>() {

    companion object {
        fun newInstance() = GameListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: GameViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var itemAdapter: FastItemAdapter<GenericItem>

    @Inject

    lateinit var layoutManager: RecyclerView.LayoutManager

    @Inject
    lateinit var clickEventHook: ClickEventHook<GenericItem>

    private val itemDecoration by lazy {
        MaterialDividerItemDecoration(requireContext(), VERTICAL).apply {
            dividerThickness = 16.dp
            dividerColor = Color.TRANSPARENT
        }
    }

    override fun getViewBinding(): GameListBinding = GameListBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GameListComponent.create(applicationComponentProvider = getAppComponent()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateList.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ResultGames.Error -> showError(result.message)
                is ResultGames.ErrorRes -> showError(result.message)
                is ResultGames.Success<*> ->{
                    val listItem = mapToGenericItem(result.model as List<GameCategory>)
                    itemAdapter.setNewList(listItem)
                }
            }
        }

        binding.listItem.adapter = itemAdapter.apply {
            addEventHook(clickEventHook)
        }
        binding.listItem.layoutManager = layoutManager
        binding.listItem.addItemDecoration(itemDecoration)

        viewModel.onInit()
    }

    private fun showError(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        itemAdapter.setNewList(listOf(ErrorItem()))
    }

    private fun showError(@StringRes message: Int) {
        showError(getString(message))
    }

    private fun mapToGenericItem(allGroupItem: List<GameCategory>): List<GenericItem> {
        val randomGame = allGroupItem.random().listGame.random()
        val itemCardRecommend = GameCardRecommendItem(randomGame)
        val otherItems = allGroupItem.map { GroupItem(it, clickEventHook) }
        return mutableListOf<GenericItem>().apply {
            add(itemCardRecommend)
            addAll(otherItems)
        }
    }

}