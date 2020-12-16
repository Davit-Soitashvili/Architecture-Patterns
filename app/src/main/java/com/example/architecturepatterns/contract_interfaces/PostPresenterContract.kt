package com.example.architecturepatterns.contract_interfaces


interface PostPresenterContract {
    fun filteredPosts()
    fun onAttach(postsContract: PostsViewContract)
    fun onDetach()
}