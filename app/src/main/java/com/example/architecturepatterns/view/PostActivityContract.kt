package com.example.architecturepatterns.view

import com.example.architecturepatterns.model.Post

interface PostActivityContract {
    fun initPosts(posts : List<Post>)
    fun initError(error : String)
}