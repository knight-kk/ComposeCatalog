package com.wkk.compose.catalog.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * JetPack Compose 版 Spinner
 *
 */

@Composable
fun Spinner(
    array: Array<String>,
    onItemSelected: (index: Int, item: String) -> Boolean
) {
    Spinner(array = array, onItemSelected = onItemSelected) { item ->
        Text(item)
    }
}


/**
 * [array] 填充列表的数据
 *
 * [onItemSelected] 选择项的响应事件，返回值代表选中后是否收起
 *
 * [itemContent] 每一项的内容
 */
@Composable
fun <T> Spinner(
    array: Array<T>,
    onItemSelected: (index: Int, item: T) -> Boolean,
    itemContent: @Composable (item: T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier.wrapContentSize()) {
        Row(modifier = Modifier
            .clickable { expanded = true }
            .padding(10.dp)) {
            itemContent(array[selectedIndex])
            Icon(Icons.Default.ArrowDropDown, contentDescription = "ArrowDropDown")
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            array.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    //函数返回值控制点击后是否收起
                    if (onItemSelected(index, item)) {
                        expanded = false
                    }
                }) {
                    itemContent(item)
                }
            }
        }
    }
}


@Composable
fun ColumnDemoPreview() {
}




