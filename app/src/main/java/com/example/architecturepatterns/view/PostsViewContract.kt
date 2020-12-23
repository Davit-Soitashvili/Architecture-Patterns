package com.example.architecturepatterns.view

import com.example.architecturepatterns.entity.Post

interface PostsViewContract {
    fun initPosts(posts : List<Post>)
    fun initError(error : String)
}