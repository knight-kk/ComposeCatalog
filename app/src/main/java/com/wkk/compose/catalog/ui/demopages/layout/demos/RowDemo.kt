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
package com.wkk.compose.catalog.ui.demopages.layout.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.wkk.compose.catalog.ui.theme.Red
import com.wkk.compose.catalog.ui.widget.Caption
import com.wkk.compose.catalog.ui.widget.Spinner

@Composable
fun RowDemo() {
    Column {
        Caption("Row 简单演示")
        RowSimpleDemo()
        Caption("Row Arrangement 演示", "Arrangement 控制主轴上的对齐方式及 children 的间距")
        RowArrangementDemo()
        Caption("Row Align演示")
        RowAlignmentDemo()
    }
}

@Composable
private fun RowSimpleDemo() {
    Row(modifier = Modifier.fillMaxWidth()) {
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
private fun RowArrangementDemo() {
    val arrangements = arrayOf(
        "Arrangement.Start" to Arrangement.Start,
        "Arrangement.End" to Arrangement.End,
        "Arrangement.Center" to Arrangement.Center,
        "Arrangement.SpaceBetween" to Arrangement.SpaceBetween,
        "Arrangement.SpaceEvenly" to Arrangement.SpaceEvenly,
        "Arrangement.SpaceAround" to Arrangement.SpaceAround,
    )

    var arrangement by remember { mutableStateOf(Arrangement.Start) }

    Row {
        Text(text = "horizontalArrangement的值为：", Modifier.padding(10.dp))
        Spinner(array = Array(arrangements.size) { arrangements[it].first }) { index, _ ->
            arrangement = arrangements[index].second
            true
        }
    }
    RowArrangement(arrangement)
}

@Composable
private fun RowArrangement(horizontalArrangement: Arrangement.Horizontal = Arrangement.Start) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .width(240.dp)
            .border(1.dp, Color.Black),
        horizontalArrangement = horizontalArrangement
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
private fun RowAlignmentDemo() {
    val alignments = arrayOf(
        "Alignment.Start" to Alignment.Top,
        "Alignment.End" to Alignment.Bottom,
        "Alignment.CenterHorizontally" to Alignment.CenterVertically,
    )
    var alignment by remember { mutableStateOf(Alignment.Top) }
    Row {
        Text(text = "horizontalAlignment的值为：", Modifier.padding(10.dp))
        Spinner(array = Array(alignments.size) { alignments[it].first }) { index, _ ->
            alignment = alignments[index].second
            true
        }
    }
    RowAlignment(alignment)
}

@Composable
private fun RowAlignment(verticalAlignment: Alignment.Vertical = Alignment.CenterVertically) {
    Row(
        modifier = Modifier
            .height(200.dp)
            .border(1.dp, Color.Black),
        verticalAlignment = verticalAlignment
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RowDemoPreview() {
    RowDemo()
}
