package com.wkk.compose.catalog.ui.demopages.layout

import com.wkk.compose.catalog.R
import com.wkk.compose.catalog.data.ComposableDemo
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.data.ItemData


val layouts = DemoCategory(
    ItemData("布局", R.drawable.icon_layout),
    listOf(
        ComposableDemo(ItemData("Modifier")) { ModifierDemo() },
        ComposableDemo(ItemData("Box")) { BoxDemo() },
        ComposableDemo(ItemData("Column")) { ColumnDemo() },
    )
)



