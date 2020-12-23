package com.example.architecturepatterns.di.posts

import com.example.architecturepatterns.presenter.posts.PostPresenter
import com.example.architecturepatterns.presenter.posts.PostPresenterContract
import dagger.Binds
import dagger.Module

@Module
abstract class PostPresenterModule {
    @Binds
    abstract fun bindPostPresenter(postPresenter : PostPresenter) : PostPresenterContract
}