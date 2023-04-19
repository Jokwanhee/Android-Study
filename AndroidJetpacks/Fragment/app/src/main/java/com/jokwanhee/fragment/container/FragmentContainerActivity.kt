package com.jokwanhee.fragment.container

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityFragmentContainerBinding

class FragmentContainerActivity : BaseActivity<ActivityFragmentContainerBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_fragment_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentContainerViewSample>(R.id.fragment_container_view)

            }
        }
    }

    override fun initView() {
    }

    override fun initEvent() {
    }
}