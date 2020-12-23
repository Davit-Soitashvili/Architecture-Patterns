package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecturepatterns.R
import com.example.architecturepatterns.di.main.DaggerMainComponent
import com.example.architecturepatterns.presenter.main.MainPresenterContract
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainPresenter: MainPresenterContract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.create().inject(this)
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