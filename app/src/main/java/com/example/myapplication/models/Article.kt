package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class Article(
  val id: Int,
  val title: String,
  @SerializedName("eyecatch_img_url") val thumbnail: String,
  @SerializedName("lead_text") val intro: String,
  val content: String,
  @SerializedName("published_at") val date: String
)
