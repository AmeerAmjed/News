package com.example.news.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.databinding.ActivityMainBinding
import com.example.news.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        setDefaultFragment()
    }

    private fun setDefaultFragment(){
        val homeFragment = HomeFragment()
        val translate = supportFragmentManager.beginTransaction()
        translate.add(R.id.root_fragment, homeFragment).commit()
    }
}