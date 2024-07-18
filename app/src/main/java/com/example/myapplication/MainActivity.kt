// MainActivity.kt
package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.ArticleAdapter
import com.example.myapplication.viewmodels.ArticleViewModel

class MainActivity : AppCompatActivity() {

  private val articleViewModel: ArticleViewModel by viewModels()
  private lateinit var recyclerView: RecyclerView
  private lateinit var articleAdapter: ArticleAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView = findViewById(R.id.recyclerView)
    val progressBar = findViewById<ProgressBar>(R.id.progressBar)

    articleAdapter = ArticleAdapter()
    recyclerView.adapter = articleAdapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    // Observe the articles LiveData
    articleViewModel.articles.observe(this) { articles ->
      articleAdapter.submitList(articles)
      progressBar.visibility = View.GONE
    }

    // Observe loading state
    articleViewModel.isLoading.observe(this) { isLoading ->
      if (isLoading) {
        progressBar.visibility = View.VISIBLE
      } else {
        progressBar.visibility = View.GONE
      }
    }

    // Fetch the articles
    articleViewModel.fetchArticles()
  }
}
