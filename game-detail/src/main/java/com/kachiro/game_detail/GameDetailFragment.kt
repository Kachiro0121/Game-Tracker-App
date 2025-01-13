package com.kachiro.game_detail

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.bumptech.glide.Glide
import com.github.terrakok.cicerone.Router
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.BaseFragment
import com.kachiro.base.dp
import com.kachiro.game_detail.adapter.ImageItem
import com.kachiro.game_detail.adapter.InfoItem
import com.kachiro.game_detail.databinding.GameDetailScreenBinding
import com.kachiro.game_detail.di.GalleryList
import com.kachiro.game_detail.di.GameDetailComponent
import com.kachiro.game_detail.di.InfoList
import com.kachiro.game_detail.dto.GameDetail
import com.kachiro.game_detail.dto.Info
import com.kachiro.game_detail.dto.Screenshots
import com.kachiro.game_detail.viewModel.DetailViewModel
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import javax.inject.Inject

class GameDetailFragment: BaseFragment<GameDetailScreenBinding>() {

    companion object{

        private const val GAME_ID = "GAME_ID"

        fun newInstance(id: Int): GameDetailFragment {
            return GameDetailFragment().apply {
                arguments = bundleOf(
                    GAME_ID to id
                )
            }
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    @InfoList
    lateinit var managerInfo: RecyclerView.LayoutManager

    @Inject
    @InfoList
    lateinit var adapterInfo: FastItemAdapter<GenericItem>

    @Inject
    @GalleryList
    lateinit var managerGallery: RecyclerView.LayoutManager

    @Inject
    @GalleryList
    lateinit var adapterGallery: FastItemAdapter<GenericItem>

    private val viewModel: DetailViewModel by viewModels { viewModelFactory }

    private val idGame: Int get() = arguments?.getInt(GAME_ID) ?: -1

    override fun getViewBinding(): GameDetailScreenBinding = GameDetailScreenBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GameDetailComponent.create(getAppComponent()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.detail.observe(viewLifecycleOwner) { detail ->
            setDetailView(detail)
        }

        binding.buttonBack.setOnClickListener {
            requireActivity().onBackPressed()
        }

        init()

        if (id < 0){
            Toast.makeText(requireContext(), "error game", Toast.LENGTH_SHORT).show()
        }else{
            viewModel.setGame(idGame)
        }

    }

    private fun init() {
       val dividerGallery = MaterialDividerItemDecoration(requireContext(), HORIZONTAL).apply {
            dividerThickness = 16.dp
            dividerColor = Color.TRANSPARENT
        }
        binding.infoGameList.apply {
            layoutManager = managerInfo
            adapter = adapterInfo
        }


        binding.gallery.apply {
            title.text = getString(R.string.gallery)
            list.apply {
                layoutManager = managerGallery
                adapter = adapterGallery
                addItemDecoration(dividerGallery)
            }
        }
    }

    private fun setDetailView(detail: GameDetail?){
        detail ?: return
        binding.title.text = detail.title
        binding.description.text = detail.description
        setPlatform(detail.platform)
        setButtonOpen(detail.gameUrl)
        setGallery(detail.screenshots)
        setGameInfo(detail)
        setImage(detail.thumbnail)
    }

    private fun setPlatform(platform: String?) {
        binding.iconPlatform.isVisible = platform != null
        val icon = when(platform){
            "Windows" -> R.drawable.pc
            "Web Browser" -> R.drawable.web
            else -> 0
        }
        binding.iconPlatform.setImageResource(icon)
    }

    private fun setButtonOpen(gameUrl: String?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gameUrl))
        binding.buttonGame.setOnClickListener {
            startActivity(intent)
        }
    }

    private fun setGameInfo(detail: GameDetail) {
        val listInfo = listOf(
            Info(
                title = getString(R.string.genre),
                value = detail.genre.orEmpty().ifEmpty { getString(R.string.none) }
            ),
            Info(
                title = getString(R.string.publisher),
                value = detail.publisher.orEmpty().ifEmpty { getString(R.string.none) }
            ),
            Info(
                title = getString(R.string.developer),
                value = detail.developer.orEmpty().ifEmpty { getString(R.string.none) }
            ),
            Info(
                title = getString(R.string.releaseDate),
                value = detail.releaseDate.orEmpty().ifEmpty { getString(R.string.none) }
            )
        ).map { InfoItem(it) }
        adapterInfo.setNewList(listInfo)
    }

    private fun setGallery(screenshots: List<Screenshots>) {
        val list = screenshots.map { ImageItem(it) }
        binding.gallery.root.isVisible = list.isNotEmpty()
        adapterGallery.setNewList(list)
    }

    private fun setImage(thumbnail: String?) {
        Glide.with(this)
            .load(thumbnail)
            .into(binding.image)
    }

}