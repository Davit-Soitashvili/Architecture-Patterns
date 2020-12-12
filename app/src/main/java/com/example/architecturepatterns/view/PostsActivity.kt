package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.view_model.PostsViewModel
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postViewModel = ViewModelProvider(this)[PostsViewModel::class.java]
        postViewModel.makePostsApiCall()
        postViewModel.posts.observe(this, Observer {
            initPostsAdapter(it)
        })

        postViewModel.error.observe(this, Observer {
            displayToastMessage(it)
        })
    }

    private fun initPostsAdapter(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }

    private fun displayToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}