package com.example.architecturepatterns.view.contract_interfaces

import com.example.architecturepatterns.model.Post

interface PostContract {
    fun initPosts(posts : List<Post>)
    fun initError(error : String)
}