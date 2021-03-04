package com.wkk.compose.catalog.ui.demopages

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.wkk.compose.catalog.data.ComposableDemo
import com.wkk.compose.catalog.ui.NavigationViewModel
import com.wkk.compose.catalog.ui.theme.AppTopBar

@Composable
fun DemoContent(navigationViewModel: NavigationViewModel, data: ComposableDemo) {

    Scaffold(
        topBar = {
            AppTopBar(
                title = data.itemData.title,
                onNavigationClick = navigationViewModel::onBack
            )
        }
    ) {
        data.content()
    }

}