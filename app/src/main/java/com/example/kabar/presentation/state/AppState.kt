package com.example.kabar.presentation.state

data class AppState(
    val isDarkTheme: Boolean = false,
    val isLoggedIn: Boolean = false,
    val userName: String? = null,
    val bookmarks: List<String> = listOf(
        "bookmark_1",
        "bookmark_2",
        "bookmark_3"
    )
)
