package com.minimarket.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.`interface`.OnProductClickListener
import com.minimarket.databinding.ProductItemBinding
import com.minimarket.entity.ProductViewEntity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ProductAdapter(
    var productList: MutableList<ProductViewEntity>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var onProductClickListener: OnProductClickListener? = null

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
        holder.bind(productList[position], onProductClickListener)

    }

    class ProductViewHolder(var binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            product: ProductViewEntity,
            onProductClickListener: OnProductClickListener?
        ) {
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
                            binding.progressBarProductImage.visibility = View.GONE
                        }

                    })
            } else {
                binding.progressBarProductImage.visibility = View.GONE
            }

            binding.constraintLayoutProductItem.setOnClickListener {
                onProductClickListener?.onProductClick(product)
            }

        }
    }

}