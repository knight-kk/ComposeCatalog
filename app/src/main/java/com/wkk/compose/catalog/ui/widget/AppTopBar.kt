package com.wkk.compose.catalog.ui.widget

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AppTopBar(
    title: String,
    navigationIcon: ImageVector = Icons.Rounded.ArrowBack,
    onNavigationClick: () -> Unit
) {
    TopAppBar(title = {
        Text(text = title)
    }, navigationIcon = {
        IconButton(onClick = onNavigationClick) {
            Icon(imageVector = navigationIcon, contentDescription = "")
        }
    })
}