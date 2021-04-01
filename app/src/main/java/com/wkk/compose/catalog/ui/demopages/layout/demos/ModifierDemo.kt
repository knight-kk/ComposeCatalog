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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModifierDemo() {

    Text(
        "Android",
        modifier = Modifier
            // 在设置size之前设置padding相当于外边距
            .padding(10.dp)
            // 此时组件占据空间大小100.dp+外边距 即大小为110.dp*110.dp
            .size(100.dp)
            // 在设置size之后设置相当于内边距，组件大小不变
            .padding(10.dp)
            // 设置背景,对应背景来说，在它之前设置的padding 就相当于外边距，所以背景的绘制大小只有90.dp*90.dp
            .background(Color.Gray)
            .padding(20.dp) // 内边距，背景大小不变
            // 添加点击事件，同理点击区域的大小90.dp-20.dp 所以可点击局域大小只有70.dp*70.dp
            .clickable(onClick = {})
    )
}
