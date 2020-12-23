package com.example.architecturepatterns.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.repository.PostsRepository
import com.example.architecturepatterns.repository.PostsRepositoryImpl

class PostsViewModel(private val postsRepository: PostsRepository = PostsRepositoryImpl.getRepositoryInstance()) :
    ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    private val _error = MutableLiveData<String>()
    val posts: LiveData<List<Post>> = _posts
    val error: LiveData<String> = _error

    fun makePostsApiCall() {
        postsRepository.getPosts { posts, error ->
            if (posts != null)
                _posts.value = getFilteredPosts(posts)
            else
                _error.value = error
        }
    }

    private fun getFilteredPosts(response: List<Post>): List<Post> {
        val filteredPosts = mutableListOf<Post>()
        response.forEach {
            if (it.id != null && it.id % 2 == 0)
                filteredPosts.add(it)
        }
        return filteredPosts
    }
}