package com.jokwanhee.fragment.createFragment.baseFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityBaseFragmentBinding

class BaseFragmentActivity : BaseActivity<ActivityBaseFragmentBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_base_fragment
    private val basicFragment by lazy {
        BasicFragment()
    }
    override fun initView() {
    }

    override fun initEvent() {
        binding.buttonBaseFragment.setOnClickListener {
            val bundle = Bundle()
            bundle.putBundle("basic_bundle", bundleOf("basic_int" to 1))
            basicFragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view_base, basicFragment)
                .commit()
        }
    }
}