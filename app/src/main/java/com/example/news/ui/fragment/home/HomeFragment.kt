package com.example.news.ui.fragment.home

import com.example.news.data.model.Article
import com.example.news.databinding.FragmentHomeBinding
import com.example.news.ui.base.BaseFragment

class HomeFragment(var newsData: List<Article>): BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {
        bindDataHomeNews(newsData)
    }

    override fun callBack() {}

    private fun  bindDataHomeNews(news: List<Article>) {
        val adapter = HomeAdapter(news)
        binding.recyclerNews.adapter = adapter
    }



}