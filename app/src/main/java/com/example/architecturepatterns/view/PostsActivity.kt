package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.models.Post
import com.example.architecturepatterns.models.ResponseState
import com.example.architecturepatterns.models.view_models.PostsViewModel
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity() {

    private val postsViewModel by lazy {
        ViewModelProvider(this)[PostsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        observeResponse()
        postsViewModel.takeAction(RequestAction.GetPosts)
    }

    private fun observeResponse() {
        val responseObserver = Observer<ResponseState> {
            when (it) {
                is ResponseState.Posts -> {
                    initPostsAdapter(it.posts)
                }
                is ResponseState.Error -> {
                    displayToastMessage(it.message)
                }
            }
        }
        postsViewModel.responseState.observe(this, responseObserver)
        postsViewModel.responseEffect.observe(this, responseObserver)
    }

    private fun initPostsAdapter(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }

    private fun displayToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}