package com.example.myapplication.network

import retrofit2.Call
import retrofit2.http.GET
import com.example.myapplication.models.ArticleResponse

interface ApiService {
  @GET("articles/public_index")
  fun getArticles(): Call<ArticleResponse>
}