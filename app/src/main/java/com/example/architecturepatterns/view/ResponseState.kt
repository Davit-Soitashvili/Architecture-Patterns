package com.example.architecturepatterns.view

import com.example.architecturepatterns.models.Post

sealed class ResponseState {
    data class Posts(val posts: List<Post>) : ResponseState()

    abstract class Effect : ResponseState()
    data class Error(val message : String) : Effect()
}