package com.example.architecturepatterns.models

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPostsResponse() : Call<MutableList<Post>>
}