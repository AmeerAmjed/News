package com.example.news.ui.fragment.details

import android.os.Build
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.news.data.model.Article
import com.example.news.databinding.FragmentDetailsBinding
import com.example.news.ui.base.BaseFragment
import com.example.news.util.dateTimeFormat

class DetailsFragment(var newsData: Article): BaseFragment<FragmentDetailsBinding>(){

    override fun bindingInflater(): FragmentDetailsBinding =
        FragmentDetailsBinding.inflate(layoutInflater)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun setUp() {
        binding.apply {
            newsData.apply {
                nameUser.text = newsData.author
                datePublishedAt.text = dateTimeFormat(publishedAt)
                titleContent.text = title
                Glide.with(root.context).load(urlToImage).into(imageContent)
            }

        }
    }

}