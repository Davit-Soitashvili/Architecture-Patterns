package com.example.architecturepatterns.presenter.main

import com.example.architecturepatterns.view.MainActivity

interface MainPresenterContract {
    fun openPosts()
    fun onAttach(mainActivity: MainActivity)
    fun onDetach()
}