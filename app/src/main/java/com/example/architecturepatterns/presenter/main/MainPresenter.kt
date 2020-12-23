package com.example.architecturepatterns.presenter.main

import com.example.architecturepatterns.router.MainRouter
import com.example.architecturepatterns.view.MainActivity
import javax.inject.Inject

class MainPresenter @Inject constructor() :
    MainPresenterContract {
    private var mainActivity: MainActivity? = null
    private var mainRouter: MainRouter? = null

    override fun onAttach(mainActivity: MainActivity) {
        this.mainActivity = mainActivity
        mainRouter = MainRouter()
    }

    override fun onDetach() {
        mainActivity = null
        mainRouter = null
    }

    override fun openPosts() {
        mainRouter!!.navigateToPostsActivity(mainActivity!!)
    }
}