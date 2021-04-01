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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wkk.compose.catalog.ui.widget.Caption

@Composable
fun BoxDemo() {
    Column {
        Caption("Box简单演示", "box 类似View 体系中的FrameLayout")
        BoxSimpleDemo()
        Caption("Box contentAlignment 属性", "对所有的 child 设置对齐方式")
        BoxContentAlignmentDemo()
        Caption("Box Align 演示", "对单个child 设置对齐方式")
        BoxAlignDemo()
    }
}

@Composable
fun BoxSimpleDemo() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Red)
        )
    }
}

@Composable
fun BoxAlignDemo() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue)
                // 设置此child 在Box的位置
                .align(Alignment.TopStart)
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Red)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun BoxContentAlignmentDemo() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color.Blue)
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
fun BoxDemoPreview() {
    Scaffold {
        BoxDemo()
    }
}
