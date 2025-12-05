package com.example.kabar.presentation.screens.HomeScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kabar.presentation.state.AppViewModel

@Composable
fun Bookmark(appViewModel: AppViewModel) {
    // declaring global state value
    val state by appViewModel.uiState.collectAsStateWithLifecycle()

    val bookmarks = state.bookmarks

    println("hhhhhhhhhhhhhhhhhhhhhh  $bookmarks")

    Text("Bookmark")
}