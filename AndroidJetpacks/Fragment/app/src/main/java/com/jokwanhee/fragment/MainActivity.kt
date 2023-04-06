package com.jokwanhee.fragment

import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
    }

    override fun initEvent() {
        with(binding){
            buttonBasicFragment
            buttonSavedInstanceStateFragment
            buttonInstanceFragment
            buttonFactoryFragment
        }
    }
}