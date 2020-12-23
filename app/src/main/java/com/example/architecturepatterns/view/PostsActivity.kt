package com.example.architecturepatterns.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturepatterns.R
import com.example.architecturepatterns.di.DaggerAppComponent
import com.example.architecturepatterns.model.Post
import com.example.architecturepatterns.presenter.PostPresenterContract
import com.example.architecturepatterns.view.adapters.PostsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostsActivity : AppCompatActivity(),
    PostActivityContract {
    @Inject
    lateinit var postPresenter: PostPresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.create().inject(this)
        postPresenter.onAttach(this)
        postPresenter.filteredPosts()
    }

    override fun onDestroy() {
        postPresenter.onDetach()
        super.onDestroy()
    }

    override fun initError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun initPosts(posts: List<Post>) {
        postsRecyclerView.layoutManager = LinearLayoutManager(this)
        postsRecyclerView.adapter = PostsAdapter(posts)
    }
}