package com.example.architecturepatterns.router

import android.app.Activity
import android.content.Intent
import com.example.architecturepatterns.view.MainActivity
import com.example.architecturepatterns.view.PostsActivity

class MainRouter {
    fun navigateToPostsActivity(mainActivity: MainActivity) {
        val intent = Intent(mainActivity, PostsActivity::class.java)
        mainActivity.startActivity(intent)
    }
}