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

import androidx.annotation.MainThread
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wkk.compose.catalog.data.Demo

class NavigationViewModel(private val homeDemo: Demo) : ViewModel() {

    var currentDemo by mutableStateOf(homeDemo)
        private set

    private val backStack = ArrayList<Demo>()

    @MainThread
    fun navigateTo(demo: Demo) {
        backStack.add(demo)
        currentDemo = demo
    }

    @MainThread
    fun onBack(): Boolean {
        val hasBackStack = backStack.isNotEmpty()
        if (hasBackStack) {
            backStack.removeLast()
            if (backStack.isNotEmpty()) {
                currentDemo = backStack.last()
            } else {
                currentDemo = homeDemo
            }
        }
        return hasBackStack
    }

    class Factory(private val demo: Demo) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return NavigationViewModel(demo) as T
        }
    }
}
