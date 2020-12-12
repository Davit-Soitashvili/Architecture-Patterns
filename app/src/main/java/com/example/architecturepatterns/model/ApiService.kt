package com.example.architecturepatterns.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPostsResponse() : Call<MutableList<Post>>
}