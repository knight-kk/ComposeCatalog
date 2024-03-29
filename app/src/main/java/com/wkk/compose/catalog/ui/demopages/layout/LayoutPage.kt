/*
 * Copyright 2021 wkk-knight
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wkk.compose.catalog.ui.demopages.layout

import com.wkk.compose.catalog.R
import com.wkk.compose.catalog.data.ComposableDemo
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.data.ItemData
import com.wkk.compose.catalog.ui.demopages.layout.demos.ColumnDemo
import com.wkk.compose.catalog.ui.demopages.layout.demos.ConstraintLayoutDemo
import com.wkk.compose.catalog.ui.demopages.layout.demos.CustomLayoutDemo
import com.wkk.compose.catalog.ui.demopages.layout.demos.LayoutConstraintDemo
import com.wkk.compose.catalog.ui.demopages.layout.demos.ModifierDemo
import com.wkk.compose.catalog.ui.demopages.layout.demos.RowDemo

val layouts = DemoCategory(
    ItemData("布局", R.drawable.icon_layout),
    listOf(
        ComposableDemo(ItemData("Modifier")) { ModifierDemo() },
        ComposableDemo(ItemData("Box")) { BoxDemo() },
        ComposableDemo(ItemData("Column")) { ColumnDemo() },
        ComposableDemo(ItemData("Row")) { RowDemo() },
        ComposableDemo(ItemData("ConstraintLayout")) { ConstraintLayoutDemo() },
        ComposableDemo(ItemData("布局中的约束")) { LayoutConstraintDemo() },
        ComposableDemo(ItemData("自定义布局")) { CustomLayoutDemo() },
    )
)
