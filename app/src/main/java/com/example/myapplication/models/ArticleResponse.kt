package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
  @SerializedName("articles") val articles: List<Article>,
  @SerializedName("total_count") val totalCount: Int,
  @SerializedName("total_pages") val totalPages: Int
)
