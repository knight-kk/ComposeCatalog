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
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wkk.compose.catalog.ui.theme.Blue
import com.wkk.compose.catalog.ui.theme.Orange
import com.wkk.compose.catalog.ui.theme.Red
import com.wkk.compose.catalog.ui.widget.Caption
import com.wkk.compose.catalog.ui.widget.Spinner

@Composable
fun ColumnDemo() {
    Column(Modifier.fillMaxSize()) {
        Caption("Column 简单演示")
        ColumnSimpleDemo()
        Caption("Column Arrangement 演示", "Arrangement 控制主轴上的对齐方式及 children 的间距")
        ColumnArrangementDemo()
        Caption("Column Align演示")
        ColumnAlignmentDemo()
    }
}

@Composable
private fun ColumnSimpleDemo() {
    Column {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Blue)
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Red)
        )
    }
}

@Composable
private fun ColumnArrangementDemo() {
    val arrangements = arrayOf(
        "Arrangement.Top" to Arrangement.Top,
        "Arrangement.Bottom" to Arrangement.Bottom,
        "Arrangement.Center" to Arrangement.Center,
        "Arrangement.SpaceBetween" to Arrangement.SpaceBetween,
        "Arrangement.SpaceEvenly" to Arrangement.SpaceEvenly,
        "Arrangement.SpaceAround" to Arrangement.SpaceAround,
    )

    var arrangement by remember { mutableStateOf(Arrangement.Top) }

    Row {
        Text(text = "verticalArrangement的值为：", Modifier.padding(10.dp))
        Spinner(array = Array(arrangements.size) { arrangements[it].first }) { index, _ ->
            arrangement = arrangements[index].second
            true
        }
    }
    ColumnArrangement(arrangement)
}

@Composable
private fun ColumnArrangement(verticalArrangement: Arrangement.Vertical = Arrangement.Top) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .height(240.dp)
            .border(1.dp, Color.Black),
        verticalArrangement = verticalArrangement
    ) {
        COLORS.forEach { color ->
            Box(
                Modifier
                    .size(50.dp)
                    .background(color)
            )
        }
    }
}

@Composable
private fun ColumnAlignmentDemo() {
    val alignments = arrayOf(
        "Alignment.Start" to Alignment.Start,
        "Alignment.End" to Alignment.End,
        "Alignment.CenterHorizontally" to Alignment.CenterHorizontally,
    )
    var alignment by remember { mutableStateOf(Alignment.Start) }
    Row {
        Text(text = "horizontalAlignment的值为：", Modifier.padding(10.dp))
        Spinner(array = Array(alignments.size) { alignments[it].first }) { index, _ ->
            alignment = alignments[index].second
            true
        }
    }
    ColumnAlignment(alignment)
}

@Composable
private fun ColumnAlignment(horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally) {
    Column(
        modifier = Modifier
            .width(240.dp)
            .border(1.dp, Color.Black),
        horizontalAlignment = horizontalAlignment
    ) {
        COLORS.forEach { color ->

            Box(
                Modifier
                    .size(50.dp)
                    .background(color)
            )
        }
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun ColumnDemoPreview() {
    Scaffold {
        ColumnDemo()
    }
}

val COLORS = arrayOf(Blue, Red, Orange)
