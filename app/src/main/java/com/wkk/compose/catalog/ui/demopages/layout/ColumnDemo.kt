package com.wkk.compose.catalog.ui.demopages.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.wkk.compose.catalog.ui.Caption

@Composable
fun ColumnDemo() {
    Column() {
        Caption("Column 简单演示")
        ColumnSimpleDemo()
    }
}

@Composable
fun ColumnSimpleDemo() {
    Column {
        Text(text = "Android")
        Text(text = "Android")
    }
}

@Composable
fun ColumnAlignDemo() {
    Column(horizontalAlignment = Alignment.Start,verticalArrangement= Arrangement.Center) {
        Text(text = "Android")
        Text(text = "Android")
    }
}


@Preview(showBackground = false, showSystemUi = true)
@Composable
fun ColumnDemoPreview() {
    ColumnDemo()
}