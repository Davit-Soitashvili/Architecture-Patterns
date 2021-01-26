package com.example.architecturepatterns.repository

import com.example.architecturepatterns.model.DataLoader
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.model.ResponseCallback
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor() : PostsRepository {
    override fun getPosts(responseCallback: (posts: List<Post>?, error: String?) -> Unit) {
        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                responseCallback(response, null)
            }

            override fun onFailure(response: String) {
                responseCallback(null, response)
            }
        })
    }
}