package com.example.news.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.news.R
import com.example.news.data.NewsRepository
import com.example.news.data.model.NewsModel
import com.example.news.data.network.State
import com.example.news.databinding.ActivityMainBinding
import com.example.news.ui.fragment.HomeFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsRepository = NewsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        requestNewsData()
        setDefaultFragment()
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
            is State.Loading -> {
                Log.i("state", "Loading")
            }
            is State.Success -> {
                Log.i("state", state.data.toString())
            }

            is State.Error -> {
                Log.i("state", "Loading")
            }
        }
    }

    private fun setDefaultFragment() {
        val homeFragment = HomeFragment()
        val translate = supportFragmentManager.beginTransaction()
        translate.add(R.id.root_fragment, homeFragment).commit()
    }
}