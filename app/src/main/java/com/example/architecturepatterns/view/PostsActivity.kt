package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.contract_interfaces.PostPresenterContract
import com.example.architecturepatterns.contract_interfaces.PostsViewContract
import com.example.architecturepatterns.entity.Post
import com.example.architecturepatterns.presenter.PostPresenter
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity(), PostsViewContract {
    private lateinit var postPresenterContract: PostPresenterContract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        postPresenterContract = PostPresenter()
        postPresenterContract.onAttach(this)
        postPresenterContract.filteredPosts()
    }

    override fun onDestroy() {
        postPresenterContract.onDetach()
        super.onDestroy()
    }

    override fun initPosts(posts: List<Post>) {
        initPostsAdapter(posts)
    }

    override fun initError(error: String) {
        displayToastMessage(error)
    }

    private fun initPostsAdapter(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }

    private fun displayToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}