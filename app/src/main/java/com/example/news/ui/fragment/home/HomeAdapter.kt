package com.example.news.ui.fragment.home

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.`interface`.InteractionListener
import com.example.news.data.model.Article
import com.example.news.databinding.ItemCardNewsBinding
import com.example.news.ui.base.BaseViewHolder
import com.example.news.util.dateTimeFormat

class HomeAdapter(var newsData: List<Article>, val listener: InteractionListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  HomeViewHolder  {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_news, parent, false)
        return HomeViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentNews: Article = newsData[position]

        holder.binding.apply {
            currentNews.apply {
                nameUser.text = author
                datePublishedAt.text = dateTimeFormat(publishedAt)
                titleContent.text = title
                Glide.with(root.context).load(urlToImage).into(imageContent)
            }

            cardNews.setOnClickListener{
                listener.OnClickItem(currentNews)
            }
        }

    }


    override fun getItemCount(): Int = newsData.size

    class HomeViewHolder(ViewItem: View): BaseViewHolder(ViewItem) {
        var binding = ItemCardNewsBinding.bind(ViewItem)
    }
}