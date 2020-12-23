package com.example.architecturepatterns.di.posts

import com.example.architecturepatterns.presenter.posts.PostPresenter
import com.example.architecturepatterns.view.PostsActivity
import dagger.Component

@Component(modules = [PostPresenterModule::class])
interface PostsComponent {
    fun getPostsPresenter(): PostPresenter
    fun inject(postsActivity: PostsActivity)
}