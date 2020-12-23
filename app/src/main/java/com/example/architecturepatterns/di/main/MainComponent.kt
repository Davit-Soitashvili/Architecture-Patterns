package com.example.architecturepatterns.di.main

import com.example.architecturepatterns.presenter.main.MainPresenter
import com.example.architecturepatterns.view.MainActivity
import dagger.Component

@Component(modules = [MainPresenterModule::class])
interface MainComponent {
    fun getMainPresenter(): MainPresenter
    fun inject(mainActivity: MainActivity)
}