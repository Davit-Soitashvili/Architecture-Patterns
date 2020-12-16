package com.example.architecturepatterns.interactor

import com.example.architecturepatterns.entity.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPostsResponse() : Call<MutableList<Post>>
}
