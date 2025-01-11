package com.kachiro.game

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.github.terrakok.cicerone.Router
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.BaseFragment
import com.kachiro.base.dp
import com.kachiro.game.adapter.GameCardRecommendItem
import com.kachiro.game.adapter.GroupItem
import com.kachiro.game.databinding.GameListBinding
import com.kachiro.game.di.GameListComponent
import com.kachiro.game.viewModels.GameViewModel
import com.kachiro.game_api.dto.GameCategory
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import javax.inject.Inject

class GameListFragment: BaseFragment<GameListBinding>() {

    companion object{
        fun newInstance() = GameListFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: GameViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var itemAdapter: FastItemAdapter<GenericItem>

    @Inject
    lateinit var layoutManager: LinearLayoutManager

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

        binding.listItem.adapter = itemAdapter.apply {
            addEventHook(clickEventHook)
        }
        binding.listItem.layoutManager = layoutManager
        binding.listItem.addItemDecoration(itemDecoration)

        viewModel.list.observe(viewLifecycleOwner){ allGroupItem ->
            Log.d("TAG", "onViewCreated: ")
            itemAdapter.setNewList(mapToGenericItem(allGroupItem))
        }
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