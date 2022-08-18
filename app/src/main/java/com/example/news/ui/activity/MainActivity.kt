package com.example.news.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.news.R
import com.example.news.data.NewsRepository
import com.example.news.data.model.Article
import com.example.news.data.model.NewsModel
import com.example.news.data.network.State
import com.example.news.databinding.ActivityMainBinding
import com.example.news.databinding.FragmentHomeBinding
import com.example.news.ui.fragment.home.HomeFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var Homebinding: FragmentHomeBinding
    private val newsRepository = NewsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        requestNewsData()
    }

    private fun requestNewsData() {
        lifecycleScope.launch(Dispatchers.Main) {
            newsRepository.getNews().collect { state ->
                stateResponseData(state)
            }
        }
    }

    private fun stateResponseData(state: State<NewsModel?>) {
        when (state) {
            is State.Loading -> onLoading()
            is State.Success -> onSuccess( state.data!!.articles)
            is State.Error -> onError()
        }
    }

    private fun onLoading() {
        binding.apply {
            loading.visibility = View.VISIBLE
            errorAnimation.visibility = View.GONE
            rootFragment.visibility = View.GONE
        }
    }

    private fun onSuccess(news: List<Article>) {
        binding.apply {
            rootFragment.visibility = View.VISIBLE
            loading.visibility = View.GONE
            errorAnimation.visibility = View.GONE
        }
        setDefaultFragment(news)
    }

    private fun onError() {
        binding.apply {
            errorAnimation.visibility = View.VISIBLE
            loading.visibility = View.GONE
            rootFragment.visibility = View.GONE
        }
    }

    private fun setDefaultFragment(news: List<Article>) {
        val homeFragment = HomeFragment(news)
        val translate = supportFragmentManager.beginTransaction()
        translate.add(R.id.root_fragment, homeFragment).commit()
    }
}