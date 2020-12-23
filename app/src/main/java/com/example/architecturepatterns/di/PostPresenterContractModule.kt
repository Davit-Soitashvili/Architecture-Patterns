package com.example.architecturepatterns.di

import com.example.architecturepatterns.presenter.PostPresenter
import com.example.architecturepatterns.presenter.PostPresenterContract
import dagger.Module
import dagger.Provides

@Module
class PostPresenterContractModule {
    @Provides
    fun providePostPresenterContract(postPresenter: PostPresenter): PostPresenterContract {
        return postPresenter
    }
}