package com.example.kabar.presentation.state

sealed class AppEvent {
    data class SetTheme(val dark: Boolean) : AppEvent()
    data class Login(val userName: String) : AppEvent()
    object Logout : AppEvent()
    data class AddBookmark(val itemId: String) : AppEvent()
    data class RemoveBookmark(val itemId: String) : AppEvent()
}
