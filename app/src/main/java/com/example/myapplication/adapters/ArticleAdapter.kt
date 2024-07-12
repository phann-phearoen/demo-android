// adapters/ArticleAdapter.kt
package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.models.Article

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

  private var articles = listOf<Article>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
    return ArticleViewHolder(view)
  }

  override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
    val article = articles[position]
    holder.bind(article)
  }

  override fun getItemCount(): Int = articles.size

  fun submitList(articles: List<Article>) {
    this.articles = articles
    notifyDataSetChanged()
  }

  class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val thumbnailImageView: ImageView = itemView.findViewById(R.id.thumbnailImageView)

    fun bind(article: Article) {
      titleTextView.text = article.title
      Glide.with(itemView.context)
        .load(article.thumbnail)
        .into(thumbnailImageView)
    }
  }
}