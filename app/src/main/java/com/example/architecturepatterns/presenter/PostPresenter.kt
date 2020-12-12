package com.example.architecturepatterns.presenter

import com.example.architecturepatterns.model.DataLoader
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.model.ResponseCallback
import com.example.architecturepatterns.view.contract_interfaces.PostContract

class PostPresenter {
    private var postContract: PostContract? = null

    fun filteredPosts() {
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

    fun onAttach(postContract: PostContract) {
        this.postContract = postContract
    }

    fun onDetach() {
        postContract = null
    }
}