package com.example.architecturepatterns.di

import com.example.architecturepatterns.presenter.PostPresenter
import com.example.architecturepatterns.view.PostsActivity
import dagger.Component

@Component(modules = [PostPresenterContractModule::class])
interface AppComponent {
    fun getPostPresenter(): PostPresenter
    fun inject(postsActivity: PostsActivity)
}