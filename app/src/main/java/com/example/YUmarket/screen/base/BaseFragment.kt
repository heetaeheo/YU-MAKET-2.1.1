package com.example.YUmarket.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    protected lateinit var binding: VB

    abstract fun getViewBinding(): VB

    private lateinit var fetchJob: Job

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initState()
    }

    open fun initState() {
        initViews()
        observeData()
        backStack()
    }

    open fun initViews() = Unit

    abstract fun observeData()

    abstract fun backStack()



}