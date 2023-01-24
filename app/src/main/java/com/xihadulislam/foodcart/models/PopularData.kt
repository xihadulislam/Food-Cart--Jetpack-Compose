package com.xihadulislam.foodcart.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularData(
    @DrawableRes val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val description: String,
    val calori: Double,
    val scheduleTime: Double,
    val ingradients: List<Int>
): Parcelable
