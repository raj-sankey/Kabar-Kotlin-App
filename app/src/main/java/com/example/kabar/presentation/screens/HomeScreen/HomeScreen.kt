package com.example.kabar.presentation.screens.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kabar.presentation.state.AppEvent
import com.example.kabar.presentation.state.AppViewModel

@Composable
fun HomeScreen(appViewModel: AppViewModel) {
    //declaring the goobal state
    val state by appViewModel.uiState.collectAsStateWithLifecycle()

    Column() {
        // Display screen title
        Text("HomeScreen")

        // Display total bookmarks count
        Text("Bookmarks Count: ${state.bookmarks.size}")

        // Button — when clicked, adds dummy data to global state
        Button (
            onClick = {
                appViewModel.onEvent(AppEvent.AddBookmark("dummy_item_${state.bookmarks.size + 1}"))
            }
        ) {
            Text("Add Dummy Bookmark")
        }
    }
}