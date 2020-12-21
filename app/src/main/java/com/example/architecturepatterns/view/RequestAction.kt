package com.example.architecturepatterns.view

sealed class RequestAction {
    object GetPosts : RequestAction()
}