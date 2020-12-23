package com.example.architecturepatterns.presenter.posts

import com.example.architecturepatterns.view.PostsViewContract
import com.example.architecturepatterns.entity.Post
import com.example.architecturepatterns.interactor.DataLoader
import com.example.architecturepatterns.interactor.ResponseCallback
import javax.inject.Inject

class PostPresenter @Inject constructor() :
    PostPresenterContract {
    private var postsContract: PostsViewContract? = null

    override fun filteredPosts() {
        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                postsContract?.initPosts(getFilteredPosts(response))
            }

            override fun onFailure(response: String) {
                postsContract?.initError(response)
            }
        })
    }

    private fun getFilteredPosts(response: MutableList<Post>): List<Post> {
        val filteredPosts = mutableListOf<Post>()
        response.forEach {
            if (it.id != null && it.id % 2 == 0)
                filteredPosts.add(it)
        }
        return filteredPosts
    }

    override fun onAttach(postsContract: PostsViewContract) {
        this.postsContract = postsContract
    }

    override fun onDetach() {
        this.postsContract = null
    }
}