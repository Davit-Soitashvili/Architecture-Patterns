package com.example.architecturepatterns.models.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepatterns.models.DataLoader
import com.example.architecturepatterns.models.Post
import com.example.architecturepatterns.models.ResponseCallback
import com.example.architecturepatterns.view.RequestAction
import com.example.architecturepatterns.view.ResponseState

class PostsViewModel : ViewModel() {
    private val _responseState = MutableLiveData<ResponseState>()
    private val _responseEffect = MutableLiveData<ResponseState.Effect>()
    val responseState: LiveData<ResponseState> = _responseState
    val responseEffect: LiveData<ResponseState.Effect> = _responseEffect

    fun takeAction(action: RequestAction) {
        when (action) {
            is RequestAction.GetPosts -> {
                makePostsApiCall()
            }
        }
    }

    private fun makePostsApiCall() {
        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                _responseState.value =  ResponseState.Posts(getFilteredPosts(response))
            }

            override fun onFailure(response: String) {
                _responseEffect.value = ResponseState.Error(response)
            }
        })
    }

    private fun getFilteredPosts(response: MutableList<Post>): List<Post> {
        val filteredPosts = mutableListOf<Post>()
        response.forEach {
            if (it.id != null && it.id % 2 == 0)
                filteredPosts.add(it)
        }
        return filteredPosts
    }
}