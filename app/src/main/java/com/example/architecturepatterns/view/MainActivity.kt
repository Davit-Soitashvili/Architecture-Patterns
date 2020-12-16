package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecturepatterns.R
import com.example.architecturepatterns.contract_interfaces.PostPresenterContract
import com.example.architecturepatterns.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainPresenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenter()
        mainPresenter.onAttach(this)

        openPostsBtn.setOnClickListener {
            mainPresenter.openPosts()
        }
    }

    override fun onDestroy() {
        mainPresenter.onDetach()
        super.onDestroy()
    }
}