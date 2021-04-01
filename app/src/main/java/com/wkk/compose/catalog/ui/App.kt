package com.wkk.compose.catalog.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.wkk.compose.catalog.data.ComposableDemo
import com.wkk.compose.catalog.data.Demo
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.data.HomeDemoModule
import com.wkk.compose.catalog.ui.demopages.DemoContent
import com.wkk.compose.catalog.ui.demopages.DemoList
import com.wkk.compose.catalog.ui.demopages.Home

@ExperimentalFoundationApi
@Composable
fun App(navigationViewModel: NavigationViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        Crossfade(navigationViewModel.currentDemo) { demo ->
            when (demo) {
                is HomeDemoModule -> Home(navigationViewModel, demo)
                is DemoCategory -> DemoList(navigationViewModel, demo)
                is ComposableDemo -> DemoContent(navigationViewModel, demo)
            }
        }
    }


}