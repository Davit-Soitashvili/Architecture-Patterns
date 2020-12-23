package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.view.PostActivityContract

interface PostPresenterContract {
    fun onAttach(postContract: PostActivityContract)
    fun filteredPosts()
    fun onDetach()
}