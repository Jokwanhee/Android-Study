package com.jokwanhee.fragment.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T:ViewDataBinding>: AppCompatActivity() {
    abstract val layoutId: Int
    private lateinit var _binding: T

    val binding: T
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        setContentView(binding.root)
        initState()
    }


    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    abstract fun initView()
    abstract fun initEvent()
    open fun initState(){
        initView()
        initEvent()
    }

}