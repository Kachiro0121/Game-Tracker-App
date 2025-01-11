package com.kachiro.base

import android.app.Dialog
import android.graphics.Outline
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.annotation.Px
import androidx.core.view.updateLayoutParams
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.withCreated
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kachiro.core_api.di.AppWithApplicationComponent
import kotlinx.coroutines.launch

abstract class FullScreenDialog<VB: ViewBinding>: BottomSheetDialogFragment() {

    protected abstract fun getViewBinding(): VB

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected fun getAppComponent() = (requireActivity().application as AppWithApplicationComponent).getApplicationComponentProvider()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding()
        return _binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setFullScreen()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun Dialog.setFullScreen(
        @Px cornerRadius: Int = 12.dp,
        skipCollapsed: Boolean = true,
        isDraggable: Boolean = true
    ) {
        check(this is BottomSheetDialog) {
            "Dialog must be a BottomSheetBottomSheetDialog."
        }

        lifecycleScope.launch {
            withCreated {
                val bottomSheetLayout = findViewById<ViewGroup>(com.google.android.material.R.id.design_bottom_sheet)  ?: return@withCreated
                with(bottomSheetLayout) {
                    updateLayoutParams {
                        height = ViewGroup.LayoutParams.MATCH_PARENT
                        width = ViewGroup.LayoutParams.MATCH_PARENT
                    }
                    clipToOutline = true
                    outlineProvider = object : ViewOutlineProvider() {
                        override fun getOutline(view: View, outline: Outline) {
                            outline.setRoundRect(
                                0,
                                0,
                                view.width,
                                view.height + cornerRadius,
                                cornerRadius.toFloat()
                            )
                        }
                    }
                }
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
                behavior.skipCollapsed = skipCollapsed
                behavior.isDraggable = isDraggable
                behavior.maxWidth = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
    }

}