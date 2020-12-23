package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.di.posts.DaggerPostsComponent
import com.example.architecturepatterns.presenter.posts.PostPresenterContract
import com.example.architecturepatterns.entity.Post
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_posts.*
import javax.inject.Inject

class PostsActivity : AppCompatActivity(),
    PostsViewContract {
    @Inject  lateinit var postPresenterContract: PostPresenterContract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        DaggerPostsComponent.create().inject(this)
        postPresenterContract.onAttach(this)
        postPresenterContract.filteredPosts()
    }

    override fun onDestroy() {
        postPresenterContract.onDetach()
        super.onDestroy()
    }

    override fun initPosts(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }

    override fun initError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}