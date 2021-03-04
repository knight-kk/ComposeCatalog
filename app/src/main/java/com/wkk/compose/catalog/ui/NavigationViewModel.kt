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