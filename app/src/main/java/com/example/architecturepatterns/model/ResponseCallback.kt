package com.example.architecturepatterns.model

interface ResponseCallback {
    fun onSuccess(response: MutableList<Post>)
    fun onFailure(response: String)
}