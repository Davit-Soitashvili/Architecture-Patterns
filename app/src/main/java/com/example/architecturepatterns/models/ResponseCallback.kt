package com.example.architecturepatterns.models

interface ResponseCallback {
    fun onSuccess(response: MutableList<Post>)
    fun onFailure(response: String)
}