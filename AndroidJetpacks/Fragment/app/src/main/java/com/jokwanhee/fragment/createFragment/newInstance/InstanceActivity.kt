package com.jokwanhee.fragment.createFragment.newInstance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityInstanceBinding

class InstanceActivity : BaseActivity<ActivityInstanceBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_instance

    private val instanceFragment by lazy {
        InstanceFragment.newInstance()
    }

    override fun initView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_new_instance, instanceFragment)
            .commit()
    }

    override fun initEvent() {
    }
}