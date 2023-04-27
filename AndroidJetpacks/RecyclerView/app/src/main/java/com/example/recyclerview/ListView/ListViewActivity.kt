package com.example.recyclerview.ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.get
import com.example.recyclerview.ListView.adapter.ListViewAdapter
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ActivityListViewBinding
import com.example.recyclerview.databinding.ActivityMainBinding

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<ListViewData>()
        for (i in 0 until 100){
            items.add(ListViewData(i.toString(), R.drawable.dock, i.toString()))
        }

        val listViewAdapter = ListViewAdapter(items, LayoutInflater.from(this))
        binding.listView.adapter = listViewAdapter
        binding.listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "${items[i]}", Toast.LENGTH_SHORT).show()

            // 클릭 시 아이템을 삭제할 때 notifyDataSetChanged() 메서드를 호출해줘야 한다.
            items.removeAt(i)
            listViewAdapter.notifyDataSetChanged()
        }
    }
}