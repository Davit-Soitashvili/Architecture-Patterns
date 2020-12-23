package com.example.architecturepatterns.di.main

import com.example.architecturepatterns.presenter.main.MainPresenter
import com.example.architecturepatterns.presenter.main.MainPresenterContract
import dagger.Binds
import dagger.Module

@Module
abstract class MainPresenterModule {
    @Binds
    abstract fun bindMainPresenter(mainPresenter: MainPresenter): MainPresenterContract
}