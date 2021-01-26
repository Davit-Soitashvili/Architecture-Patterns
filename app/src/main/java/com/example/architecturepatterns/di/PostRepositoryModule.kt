package com.example.architecturepatterns.di

import com.example.architecturepatterns.repository.PostsRepository
import com.example.architecturepatterns.repository.PostsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface PostRepositoryModule {
    @Singleton
    @Binds
    fun bindPostRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository
}