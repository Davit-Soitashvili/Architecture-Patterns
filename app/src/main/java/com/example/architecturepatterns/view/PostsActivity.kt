package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.di.DaggerAppComponent
import com.example.architecturepatterns.view_model.PostsViewModel
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostsActivity : AppCompatActivity() {

    @Inject
    lateinit var postViewModel: PostsViewModel

    @Inject
    lateinit var postViewModel2: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.create().inject(this)

        postViewModel.makePostsApiCall()
        postViewModel.posts.observe(this, Observer {
            postsRecyclerView.layoutManager = LinearLayoutManager(this)
            postsRecyclerView.adapter = PostsAdapter(it)
        })

        postViewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}