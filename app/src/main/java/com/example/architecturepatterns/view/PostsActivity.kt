package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.presenter.PostPresenter
import com.example.architecturepatterns.view.adapters.PostsAdapter
import com.example.architecturepatterns.view.contract_interfaces.PostContract
import kotlinx.android.synthetic.main.activity_main.*

class PostsActivity : AppCompatActivity(), PostContract {
    private lateinit var postPresenter: PostPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postPresenter = PostPresenter()
        postPresenter.onAttach(this)
        postPresenter.filteredPosts()
    }

    override fun onDestroy() {
        postPresenter.onDetach()
        super.onDestroy()
    }

    override fun initError(error: String) {
        displayToastMessage(error)
    }

    override fun initPosts(posts: List<Post>) {
        initPostsAdapter(posts)
    }

    private fun initPostsAdapter(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }

    private fun displayToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}