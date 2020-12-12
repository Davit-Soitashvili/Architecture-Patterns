package com.example.architecturepatterns.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepatterns.model.DataLoader
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.model.ResponseCallback

class PostsViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    private val _error = MutableLiveData<String>()
    val posts: LiveData<List<Post>> = _posts
    val error: LiveData<String> = _error

    fun makePostsApiCall() {
        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                _posts.value = getFilteredPosts(response)
            }

            override fun onFailure(response: String) {
                _error.value = response
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