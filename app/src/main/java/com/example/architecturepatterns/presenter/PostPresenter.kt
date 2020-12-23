package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.model.DataLoader
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.model.ResponseCallback
import com.example.architecturepatterns.view.PostActivityContract
import javax.inject.Inject


class PostPresenter @Inject constructor(): PostPresenterContract{
    private var postContract: PostActivityContract? = null

    override fun filteredPosts() {
        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                postContract?.initPosts(getFilteredPosts(response))
            }

            override fun onFailure(response: String) {
                postContract?.initError(response)
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

    override fun onAttach(postContract: PostActivityContract) {
        this.postContract = postContract
    }

    override fun onDetach() {
        postContract = null
    }
}