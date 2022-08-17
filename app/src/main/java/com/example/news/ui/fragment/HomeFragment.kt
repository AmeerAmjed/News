package com.example.news.ui.fragment

import com.example.news.databinding.FragmentHomeBinding
import com.example.news.ui.base.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {}

    override fun callBack() {}
}