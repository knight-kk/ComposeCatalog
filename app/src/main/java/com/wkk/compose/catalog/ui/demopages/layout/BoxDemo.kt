package com.wkk.compose.catalog.ui.demopages.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BoxDemo() {
    Box(modifier = Modifier
        .size(50.dp)
        .background(Color.Blue)) {}
}