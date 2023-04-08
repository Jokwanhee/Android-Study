package com.jokwanhee.fragment.fragmentstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityStateBinding

class StateActivity : BaseActivity<ActivityStateBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_state

    private val stateFragment by lazy {
        StateFragment.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (savedInstanceState != null){
//        } else {
//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_container_view_state, stateFragment, "state_fragment")
//            .commit()
//          }
        val state = supportFragmentManager.findFragmentByTag("state_fragment")
        if (state != null){

        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view_state, stateFragment,"state_fragment")
                .commit()
        }
    }

    override fun initView() {

    }

    override fun initEvent() {
    }
}