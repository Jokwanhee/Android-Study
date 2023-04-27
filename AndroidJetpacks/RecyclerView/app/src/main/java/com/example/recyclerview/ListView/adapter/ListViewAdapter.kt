package com.example.recyclerview.ListView.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview.ListView.ListViewData
import com.example.recyclerview.R

class ListViewAdapter(
    private val listViewList: List<ListViewData>,
    private val layoutInflater: LayoutInflater
): BaseAdapter() {
    override fun getCount(): Int {
        return listViewList.size
    }

    override fun getItem(position: Int): Any {
        return listViewList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, container: ViewGroup?): View {
        var view = convertView
        if (convertView == null){
            view = layoutInflater.inflate(R.layout.item_list_view, container, false)
        }

        val item: ListViewData = listViewList[position]
        with(view!!){
            findViewById<TextView>(R.id.list_view_title).text = item.title
            findViewById<ImageView>(R.id.list_view_image).setImageResource(item.image)
            findViewById<TextView>(R.id.list_view_desc).text = item.description
        }

        return view
    }
}