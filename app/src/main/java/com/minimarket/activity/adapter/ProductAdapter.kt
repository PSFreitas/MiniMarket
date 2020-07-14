package com.minimarket.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.databinding.ProductItemBinding
import com.minimarket.domain.entities.ProductEntity

class ProductAdapter(
    var productList: MutableList<ProductEntity>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = DataBindingUtil.inflate<ProductItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.product_item,
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.productItem = productList[position]

    }

    class ProductViewHolder(var binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

}