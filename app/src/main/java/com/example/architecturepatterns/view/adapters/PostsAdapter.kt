package com.example.architecturepatterns.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturepatterns.R
import com.example.architecturepatterns.model.Post
import kotlinx.android.synthetic.main.post_recycler_item.view.*

class PostsAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.post_recycler_item, parent, false
        )
    )

    override fun getItemCount() = posts.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.itemView.apply {
            userIdTextView.text = "User ID: ${post.userId}"
            idTextView.text = "ID : ${post.id}"
            titleTextView.text = "Title: ${post.title}"
            bodyTextView.text = "Body: ${post.title}"
        }
    }
}