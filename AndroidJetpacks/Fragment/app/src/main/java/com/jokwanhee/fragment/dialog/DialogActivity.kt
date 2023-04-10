package com.jokwanhee.fragment.dialog

import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityDialogFragmentBinding

class DialogActivity : BaseActivity<ActivityDialogFragmentBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_dialog_fragment
    private val customDialogFragment by lazy {
        CustomDialogFragment.newInstance()
    }


    override fun initView() {
    }

    override fun initEvent() {
        binding.buttonDialog.setOnClickListener {
            customDialogFragment.show(supportFragmentManager, "custom_dialog")
        }

    }
}