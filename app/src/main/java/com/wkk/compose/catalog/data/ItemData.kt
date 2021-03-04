package com.wkk.compose.catalog.data

import androidx.annotation.DrawableRes


/**
 * 条目数据
 */
data class ItemData(
    val title: String,
    @DrawableRes val iconResId: Int = 0,
    val desc: String? = null
)