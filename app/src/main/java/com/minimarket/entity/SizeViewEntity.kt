package com.minimarket.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SizeViewEntity(
    val isAvailable: Boolean,
    val size: String
):Parcelable