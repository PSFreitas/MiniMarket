package com.minimarket.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minimarket.R
import com.minimarket.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(
    private val products: List<Product>,
    private val context: Context
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.onBindView(product)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBindView(product: Product) {
            itemView.textView_product_name.text = product.name

            if (product.image.isNotEmpty()) {
                Picasso
                    .get()
                    .load(product.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.color.cardview_dark_background)
                    .into(itemView.imageView_product_image)
            }

        }
    }

}