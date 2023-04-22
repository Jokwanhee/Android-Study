package com.jokwanhee.fragment.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.jokwanhee.fragment.R
import com.jokwanhee.fragment.base.BaseActivity
import com.jokwanhee.fragment.databinding.ActivityNetworkBinding
import com.jokwanhee.fragment.databinding.FragmentListViewmodelBinding

class NetworkActivity : BaseActivity<ActivityNetworkBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_network

    private val viewModel: ItemViewModel by viewModels()

    override fun initView() {
    }

    override fun initEvent() {
        viewModel.selectedItem.observe(this, Observer { item ->

        })
    }
}

class ListFragment : Fragment(){
    private lateinit var binding: FragmentListViewmodelBinding
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListViewmodelBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun onItemClicked(item: Item) {
        // Set a new item
        viewModel.selectItem(item)
    }
}