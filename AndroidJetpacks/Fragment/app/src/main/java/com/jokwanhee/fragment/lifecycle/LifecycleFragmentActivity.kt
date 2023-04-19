package com.jokwanhee.fragment.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityLifecycleFragmentBinding

class LifecycleFragmentActivity : BaseActivity<ActivityLifecycleFragmentBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_lifecycle_fragment
    private val firstFragment by lazy {
        FirstFragment.newInstance("1", "1")
    }
    private val secondFragment by lazy {
        SecondFragment.newInstance("2", "2")
    }


    override fun initView() {
    }

    override fun initEvent() {
        binding.button1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, firstFragment)
                .commit()
        }
        binding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, secondFragment)
                .commit()
        }
    }
}