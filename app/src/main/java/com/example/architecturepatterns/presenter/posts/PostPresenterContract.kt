package com.example.architecturepatterns.presenter.posts

import com.example.architecturepatterns.view.PostsViewContract


interface PostPresenterContract {
    fun filteredPosts()
    fun onAttach(postsContract: PostsViewContract)
    fun onDetach()
}