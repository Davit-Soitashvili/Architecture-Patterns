package com.example.architecturepatterns.contract_interfaces

import com.example.architecturepatterns.entity.Post

interface PostsViewContract {
    fun initPosts(posts : List<Post>)
    fun initError(error : String)
}