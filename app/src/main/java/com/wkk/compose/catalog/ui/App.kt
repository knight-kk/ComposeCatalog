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
package com.wkk.compose.catalog.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.wkk.compose.catalog.data.ComposableDemo
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
