package com.example.architecturepatterns.view

sealed class PostRequestIntent {
    object GetPosts : PostRequestIntent()
}