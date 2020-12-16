package com.example.architecturepatterns.contract_interfaces

import com.example.architecturepatterns.view.MainActivity

interface MainPresenterContract {
    fun openPosts()
    fun onAttach(mainActivity: MainActivity)
    fun onDetach()
}