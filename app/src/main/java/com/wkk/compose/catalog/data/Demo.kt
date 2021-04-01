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
package com.wkk.compose.catalog.data

import androidx.compose.runtime.Composable

sealed class Demo(val itemData: ItemData,)

/**
 * 用来描述 Demo板块, [demos]表示此板块下的Demo
 */
class HomeDemoModule(val demos: List<Demo>) : Demo(ItemData("home"))

/**
 * 用来描述 Demo类别, [demos]表示此类别下的Demo
 */
class DemoCategory(itemData: ItemData, val demos: List<Demo>) : Demo(itemData)

/**
 * 用来描述每个Demo的信息 [content] 表示此类别对应的Composable界面
 */
class ComposableDemo(itemData: ItemData, val content: @Composable () -> Unit) : Demo(itemData)
