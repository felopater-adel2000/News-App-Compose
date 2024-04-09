package com.jetpack.compose.news.presentation.common

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

@Composable
inline fun <reified T: ViewModel> composeViewModel(): T {
    val activity = LocalContext.current as ComponentActivity
    val viewModel: T by activity.viewModels()
    return viewModel
}