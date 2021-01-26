package com.example.architecturepatterns.di

import com.example.architecturepatterns.view.PostsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PostRepositoryModule::class])
interface AppComponent {
    fun inject(postsActivity: PostsActivity)
}