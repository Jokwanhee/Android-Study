package com.jokwanhee.fragment.createFragment.newInstance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class InstanceFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(): InstanceFragment{
            val fragment = InstanceFragment()
            val args = Bundle().apply {
                putBundle("bundleInstance", bundleOf("bundleData" to "newInstance"))
            }
            fragment.arguments = args
//            args.putBundle("bundleInstance", bundleOf("bundleData" to "newInstance"))
//            fragment.arguments = args
            return fragment
        }
    }
}