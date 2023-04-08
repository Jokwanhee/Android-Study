package com.jokwanhee.fragment.createFragment.fragmentFactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityFactoryBinding

class FactoryActivity : BaseActivity<ActivityFactoryBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_factory
    private lateinit var fragment: Fragment

    override fun initView() {
        initFactory()
    }

    override fun initEvent() {
    }

    fun initFactory(){
        supportFragmentManager.fragmentFactory = FragmentFactoryImpl(100)

        with(binding){
            buttonFactoryFragmentOne.setOnClickListener {
                fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, OneFragment::class.java.name)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view_factory, fragment)
                    .commitNow()
            }
            buttonFactoryFragmentTwo.setOnClickListener {
                fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, TwoFragment::class.java.name)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view_factory, fragment)
                    .commitNow()
            }
            buttonFactoryFragmentThree.setOnClickListener {
                fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, ThreeFragment::class.java.name)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view_factory, fragment)
                    .commitNow()
            }
        }

    }
}