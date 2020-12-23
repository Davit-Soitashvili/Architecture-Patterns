package com.example.architecturepatterns.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturepatterns.R
import com.example.architecturepatterns.databinding.PostRecyclerItemBinding
import com.example.architecturepatterns.model.Post
import kotlinx.android.synthetic.main.post_recycler_item.view.*

class PostsAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    class PostViewHolder(val binding: PostRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        PostRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun getItemCount() = posts.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.post = posts[position]
    }
}