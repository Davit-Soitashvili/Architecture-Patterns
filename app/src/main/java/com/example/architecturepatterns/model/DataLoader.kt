package com.example.architecturepatterns.model

import com.example.architecturepatterns.model.RetrofitClient.apiService
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