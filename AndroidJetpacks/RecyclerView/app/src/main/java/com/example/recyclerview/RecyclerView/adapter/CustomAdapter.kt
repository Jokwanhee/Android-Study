package com.example.recyclerview.RecyclerView.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId.FocusObserver
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.RecyclerView.data.CustomData
import com.example.recyclerview.databinding.ItemListViewBinding

class CustomAdapter(
//    private val dataSet: Array<String>
    private val dataSet: List<CustomData>,
    private val context: Context
): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null
    private var onItemLongClickListener: OnItemClickListener? = null

    interface OnItemClickListener{
        fun onClick(customData: CustomData)
        fun onLongClick(customData: CustomData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.onItemClickListener = listener
    }
    fun setOnItemLongClickListener(listener: OnItemClickListener){
        this.onItemLongClickListener = listener
    }


    inner class ViewHolder(view : View): RecyclerView.ViewHolder(view){
//        val textView: TextView
//
//        init {
//            textView = view.findViewById(R.id.list_view_title)
//        }

        val container = view.findViewById<ConstraintLayout>(R.id.item_list_container)
        val image: ImageView = view.findViewById(R.id.list_view_image)
        val title: TextView = view.findViewById(R.id.list_view_title)
        val desc: TextView = view.findViewById(R.id.list_view_desc)

        fun bind(customData: CustomData){
            image.setImageResource(customData.image)
            title.text = customData.title
            desc.text = customData.description
            container.setOnClickListener {
                setOnItemClickListener(context as OnItemClickListener)
                onItemClickListener?.onClick(customData)
            }
            container.setOnLongClickListener {
                setOnItemLongClickListener(context as OnItemClickListener)
                onItemLongClickListener?.onLongClick(customData)
                false
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text = dataSet[position]
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}

