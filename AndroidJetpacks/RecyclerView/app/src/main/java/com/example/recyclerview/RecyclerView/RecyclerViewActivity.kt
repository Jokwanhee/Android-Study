package com.example.recyclerview.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerview.R
import com.example.recyclerview.RecyclerView.adapter.CustomAdapter
import com.example.recyclerview.RecyclerView.adapter.CustomBindingAdapter
import com.example.recyclerview.RecyclerView.data.CustomData
import com.example.recyclerview.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {
    private lateinit var binding: ActivityRecyclerViewBinding
//    private lateinit var adapter: CustomAdapter
    private lateinit var adapter: CustomBindingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arr = mutableListOf<CustomData>()
        for (i in 0..1000){
            arr.add(CustomData(R.drawable.dock, "오리$i", "오리$i 등장"))
        }
//        adapter = CustomAdapter(arr, this)
        adapter = CustomBindingAdapter(arr)
        adapter.itemClickListener = object: CustomBindingAdapter.OnItemBindingClickListener{
            override fun onItemBindingClick(title: String) {
                Toast.makeText(this@RecyclerViewActivity, "짧게 누르기", Toast.LENGTH_SHORT).show()
            }

            override fun onItemBindingLongClick(title: String) {
                Toast.makeText(this@RecyclerViewActivity, "길게 누르기", Toast.LENGTH_SHORT).show()
            }
        }
        binding.recyclerViewContainer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewContainer.adapter = adapter
    }

    override fun onClick(customData: CustomData) {
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show()
    }

    override fun onLongClick(customData: CustomData) {
        Toast.makeText(this, "onLongClick", Toast.LENGTH_SHORT).show()
    }
}