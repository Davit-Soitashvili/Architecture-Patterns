package com.example.architecturepatterns.interactor

import com.example.architecturepatterns.entity.Post


interface ResponseCallback {
    fun onSuccess(response: MutableList<Post>)
    fun onFailure(response: String)
}