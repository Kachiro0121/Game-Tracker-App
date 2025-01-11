package com.kachiro.game_detail

import android.os.Bundle
import android.view.View
import com.kachiro.base.BaseFragment
import com.kachiro.base.FullScreenDialog
import com.kachiro.game_detail.databinding.GameDetailScreenBinding
import com.kachiro.game_detail.di.GameDetailComponent

class GameDetailDialog: BaseFragment<GameDetailScreenBinding>() {

    companion object{
        fun newInstance() = GameDetailDialog()
    }

    override fun getViewBinding(): GameDetailScreenBinding = GameDetailScreenBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GameDetailComponent.create(getAppComponent()).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}