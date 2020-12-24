package com.example.architecturepatterns.models

sealed class ResponseState {
    data class Posts(val posts: List<Post>) : ResponseState()

    abstract class Effect : ResponseState()
    data class Error(val message : String) : Effect()
}