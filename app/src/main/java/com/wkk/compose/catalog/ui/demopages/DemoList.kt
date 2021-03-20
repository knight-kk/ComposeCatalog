package com.wkk.compose.catalog.ui.demopages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.ui.NavigationViewModel
import com.wkk.compose.catalog.ui.theme.AppTopBar

@Composable
fun DemoList(navigationViewModel: NavigationViewModel, data: DemoCategory) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = data.itemData.title,
                onNavigationClick = navigationViewModel::onBack
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(data.demos) { demo ->
                Text(
                    text = demo.itemData.title,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigationViewModel.navigateTo(demo)
                        }
                        .padding(10.dp)
                )

                Divider()
            }
        }

    }


}