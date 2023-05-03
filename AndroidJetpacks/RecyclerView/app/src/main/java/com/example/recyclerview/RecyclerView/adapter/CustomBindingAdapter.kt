package com.example.recyclerview.RecyclerView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.RecyclerView.data.CustomData
import com.example.recyclerview.databinding.ItemListViewBinding

class CustomBindingAdapter(
    private val dataSet: List<CustomData>
): RecyclerView.Adapter<CustomBindingAdapter.ViewHolder>(){

    interface OnItemBindingClickListener{
        fun onItemBindingClick(title: String)
        fun onItemBindingLongClick(title: String)
    }
    var itemClickListener: OnItemBindingClickListener? = null
    var itemLongClickListener: OnItemBindingClickListener? = null
    inner class ViewHolder(val binding: ItemListViewBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemBindingClick(dataSet[adapterPosition].title)
            }
            binding.root.setOnLongClickListener{
                itemLongClickListener?.onItemBindingLongClick(dataSet[adapterPosition].title)
                false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(
            ItemListViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            listViewImage.setImageResource(dataSet[position].image)
            listViewTitle.text = dataSet[position].title
            listViewDesc.text = dataSet[position].description
        }
    }

    override fun getItemCount(): Int = dataSet.size
}