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
class DemoCategory( itemData: ItemData, val demos: List<Demo>) : Demo(itemData)

/**
 * 用来描述每个Demo的信息 [content] 表示此类别对应的Composable界面
 */
class ComposableDemo( itemData: ItemData, val content: @Composable () -> Unit) : Demo(itemData)
