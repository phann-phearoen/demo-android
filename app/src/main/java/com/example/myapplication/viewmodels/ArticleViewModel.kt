package com.example.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Article
import com.example.myapplication.models.ArticleResponse
import com.example.myapplication.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {
  val articles = MutableLiveData<List<Article>>()
  val isLoading = MutableLiveData<Boolean>()

  init {
    fetchArticles()
  }

  fun fetchArticles() {
    isLoading.value = true

    RetrofitInstance.api.getArticles().enqueue(object : Callback<ArticleResponse> {
      override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {
        if (response.isSuccessful) {
          articles.value = response.body()?.articles
        } else {
          // Handle error response
        }
        isLoading.value = false
      }

      override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
        // Handle network failure
        isLoading.value = false
      }
    })
  }
}