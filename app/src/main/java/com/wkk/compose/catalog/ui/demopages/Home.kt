package com.wkk.compose.catalog.ui.demopages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wkk.compose.catalog.R
import com.wkk.compose.catalog.data.Demo
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.data.HomeDemoModule
import com.wkk.compose.catalog.data.ItemData
import com.wkk.compose.catalog.ui.NavigationViewModel
import com.wkk.compose.catalog.ui.demopages.layout.layouts


val homeDemoModule = HomeDemoModule(
    listOf(
        layouts,
        DemoCategory(ItemData("主题", R.drawable.icon_theming), listOf()),
        DemoCategory(ItemData("状态", R.drawable.icon_sync), listOf()),
        DemoCategory(ItemData("布局", R.drawable.icon_theming), listOf()),
        DemoCategory(ItemData("布局", R.drawable.icon_layout), listOf()),
        DemoCategory(ItemData("布局", R.drawable.icon_layout), listOf()),
    )
)

@ExperimentalFoundationApi
@Composable
fun Home(navigator: NavigationViewModel, data: HomeDemoModule) {
    Home( data, navigator::navigateTo)
}

@ExperimentalFoundationApi
@Composable
fun Home(data: HomeDemoModule, onItemClick: (demo: Demo) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) })
        },
    ) {
        val count = 2
        LazyVerticalGrid(cells = GridCells.Fixed(count), contentPadding = PaddingValues(10.dp)) {
            items(data.demos) { demo ->
                Box(Modifier.padding(10.dp), contentAlignment = Alignment.Center) {
                    HomeItem(
                        data = demo.itemData,
                        modifier = Modifier.fillMaxWidth()
                    ) { onItemClick(demo) }
                }
            }
        }
    }
}


@Composable
fun HomeItem(data: ItemData, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(modifier.clickable(onClick = onClick)) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = ImageVector.vectorResource(data.iconResId),
                contentDescription = "",
                modifier = Modifier.padding(10.dp)
            )
            Text(text = data.title, fontSize = 20.sp)
        }
    }

}