package com.example.news.ui.fragment.home

import com.example.news.R
import com.example.news.`interface`.InteractionListener
import com.example.news.data.model.Article
import com.example.news.databinding.FragmentHomeBinding
import com.example.news.ui.base.BaseFragment
import com.example.news.ui.fragment.details.DetailsFragment

class HomeFragment(var newsData: List<Article>): BaseFragment<FragmentHomeBinding>(),
    InteractionListener {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {
        bindDataHomeNews(newsData)
    }


    private fun  bindDataHomeNews(news: List<Article>) {
        val adapter = HomeAdapter(news,this)
        binding.recyclerNews.adapter = adapter
    }

    override fun OnClickItem(data: Article) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.root_fragment, DetailsFragment(data))
        transaction.addToBackStack(null).commit()
    }


}