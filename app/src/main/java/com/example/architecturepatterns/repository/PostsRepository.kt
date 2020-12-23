package com.example.architecturepatterns.repository

import com.example.architecturepatterns.model.Post

interface PostsRepository {
    fun getPosts(responseCallback : (posts : List<Post>?, error : String?) -> Unit)
}