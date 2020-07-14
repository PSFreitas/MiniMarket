package com.minimarket.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductViewEntity(
    val name: String,
    val style: String,
    val color: String,
    val isOnSale: Boolean,
    val regularPrice: String,
    val actualPrice: String,
    val image: String,
    val existentSizes: List<SizeViewEntity>
) : Parcelable
