package com.example.architecturepatterns.models

import com.example.architecturepatterns.models.RetrofitClient.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataLoader {
    fun getPosts(responseCallback: ResponseCallback) {
        apiService.getPostsResponse().enqueue(object : Callback<MutableList<Post>> {
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                responseCallback.onFailure(t.toString())
            }

            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                if (response.isSuccessful) {
                    responseCallback.onSuccess(response.body()!!)
                } else
                    responseCallback.onFailure(response.message())
            }
        })
    }
}