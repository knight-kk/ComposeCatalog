package com.wkk.compose.catalog

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wkk.compose.catalog.data.ComposableDemo
import com.wkk.compose.catalog.data.DemoCategory
import com.wkk.compose.catalog.data.HomeDemoModule
import com.wkk.compose.catalog.ui.App
import com.wkk.compose.catalog.ui.NavigationViewModel
import com.wkk.compose.catalog.ui.demopages.DemoContent
import com.wkk.compose.catalog.ui.demopages.DemoList
import com.wkk.compose.catalog.ui.demopages.Home
import com.wkk.compose.catalog.ui.demopages.homeDemoModule
import com.wkk.compose.catalog.ui.theme.ComposeCatalogTheme

class MainActivity : AppCompatActivity() {
    private val navigationViewModel by viewModels<NavigationViewModel>() {
        NavigationViewModel.Factory(homeDemoModule)
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatalogTheme {
                App(navigationViewModel = navigationViewModel)
            }
        }
    }

    override fun onBackPressed() {
        if (!navigationViewModel.onBack()) {
            super.onBackPressed()
        }
    }
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCatalogTheme {
        Home(data = homeDemoModule) {}
    }
}