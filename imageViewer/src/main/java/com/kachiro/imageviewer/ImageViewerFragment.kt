package com.kachiro.imageviewer

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.gson.Gson
import com.kachiro.base.BaseFragment
import com.kachiro.imageviewer.databinding.ImageViewerScreenBinding
import com.kachiro.imageviewer.di.ImageViewerComponent
import com.kachiro.imageviewer_api.dto.ImagesModel
import com.kachiro.imageviewer.viewModel.ImageViewerViewModel
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter

class ImageViewerFragment: BaseFragment<ImageViewerScreenBinding>() {

    companion object{
        private const val ARG_IMAGE = "images"

        fun newInstance(modelImage: ImagesModel): ImageViewerFragment {
            return ImageViewerFragment().apply {
                arguments = bundleOf(
                    ARG_IMAGE to Gson().toJson(modelImage)
                )
            }
        }
    }

    private val viewModel: ImageViewerViewModel by viewModels()

    override fun getViewBinding(): ImageViewerScreenBinding = ImageViewerScreenBinding.inflate(layoutInflater)

    private val fastAdapter = FastItemAdapter<GenericItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImageViewerComponent.create(getAppComponent()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPage()
        subscribeToViewModel()
        arguments?.getString(ARG_IMAGE)?.let {
            val model = Gson().fromJson(it, ImagesModel::class.java)
            viewModel.setImageData(model)

        }

        binding.included.buttonBack.setOnClickListener { requireActivity().onBackPressed() }

        viewModel.currentIndex.observe(viewLifecycleOwner) { index ->
            binding.included.counter.text = String.format("%s / %s", index + 1, viewModel.imageData.value?.size ?: 0)
        }

    }

    private fun setupViewPage() {
        binding.viewPage.adapter = fastAdapter
        binding.viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.setCurrentIndex(position)
            }
        })
    }

    private fun subscribeToViewModel() {
        viewModel.imageData.observe(viewLifecycleOwner){ items ->
            val position = items.indexOfFirst { it.isSelected }
            fastAdapter.setNewList(items)
            binding.viewPage.setCurrentItem(position, false)
        }
    }

}