package com.example.architecturepatterns.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.adapters.PostsAdapter
import com.example.architecturepatterns.model.DataLoader
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.model.ResponseCallback
import kotlinx.android.synthetic.main.activity_main.*

class PostsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DataLoader.getPosts(object : ResponseCallback {
            override fun onSuccess(response: MutableList<Post>) {
                val filteredPosts = mutableListOf<Post>()
                response.forEach {
                    if (it.id != null && it.id % 2 == 0)
                        filteredPosts.add(it)
                }
                initPostsAdapter(filteredPosts)
            }

            override fun onFailure(response: String) {
                displayToastMessage(response)
            }
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