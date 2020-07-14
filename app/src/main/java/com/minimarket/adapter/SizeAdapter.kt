package com.minimarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.databinding.SizeItemBinding
import com.minimarket.entity.SizeViewEntity

class SizeAdapter(
    var sizes: List<SizeViewEntity>
) : RecyclerView.Adapter<SizeAdapter.SizeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        val binding = DataBindingUtil.inflate<SizeItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.size_item,
            parent,
            false
        )

        return SizeViewHolder(binding)
    }

    override fun getItemCount(): Int = sizes.size

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        holder.bind(sizes[position])
    }

    class SizeViewHolder(var binding: SizeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(size: SizeViewEntity) {
            binding.productSize = size
        }
    }

}