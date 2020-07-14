package com.minimarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.databinding.ProductItemBinding
import com.minimarket.domain.entities.ProductEntity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

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
        holder.bind(productList[position])

    }

    class ProductViewHolder(var binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductEntity) {
            binding.productItem = product

            if (product.image.isNotEmpty()) {
                Picasso
                    .get()
                    .load(product.image)
                    .placeholder(android.R.color.white)
                    .error(R.color.cardview_dark_background)
                    .into(binding.imageViewProductImage, object : Callback {
                        override fun onSuccess() {
                            binding.progressBarProductImage.visibility = View.GONE
                        }

                        override fun onError(e: Exception?) {
                            TODO("Not yet implemented")
                        }

                    })
            } else {
                binding.progressBarProductImage.visibility = View.GONE
            }

        }
    }

}