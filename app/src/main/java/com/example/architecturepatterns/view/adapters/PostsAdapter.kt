package com.example.architecturepatterns.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturepatterns.databinding.PostRecyclerItemBinding
import com.example.architecturepatterns.models.Post

class PostsAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    class PostViewHolder(val binding: PostRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        PostRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
    )
    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.post = posts[position]
    }
}