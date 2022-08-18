package com.example.news.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.news.R

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    private lateinit var _binding: VB
    protected val binding: VB
        get() = _binding

    abstract fun bindingInflater(): VB

    abstract fun setUp()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater()

        setUp()

        return _binding.root
    }
}