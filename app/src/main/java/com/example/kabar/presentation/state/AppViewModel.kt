package com.example.kabar.presentation.state

import android.app.Application
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabar.data.AppPrefsKeys
import com.example.kabar.data.appDataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val dataStore = application.appDataStore

    // Backing field (mutable)
    private val _uiState = MutableStateFlow(AppState())
    // Public, read-only state
    val uiState: StateFlow<AppState> = _uiState

    init {
        // Load persisted state when ViewModel is created
        viewModelScope.launch {
            dataStore.data
                .map { prefs ->
                    AppState(
                        isDarkTheme = prefs[AppPrefsKeys.IS_DARK_THEME] ?: false,
                        isLoggedIn = prefs[AppPrefsKeys.IS_LOGGED_IN] ?: false,
                        userName = prefs[AppPrefsKeys.USER_NAME],
                        // if nothing saved yet, keep your 3 dummy bookmarks
                        bookmarks = prefs[AppPrefsKeys.BOOKMARKS]?.toList()
                            ?: listOf("bookmark_1", "bookmark_2", "bookmark_3")
                    )
                }
                .collect { loadedState ->
                    _uiState.value = loadedState
                }
        }
    }

    // Save current state to DataStore
    private fun persistState(newState: AppState) {
        viewModelScope.launch {
            dataStore.edit { prefs ->
                prefs[AppPrefsKeys.IS_DARK_THEME] = newState.isDarkTheme
                prefs[AppPrefsKeys.IS_LOGGED_IN] = newState.isLoggedIn

                if (newState.userName != null) {
                    prefs[AppPrefsKeys.USER_NAME] = newState.userName
                } else {
                    prefs.remove(AppPrefsKeys.USER_NAME)
                }

                prefs[AppPrefsKeys.BOOKMARKS] = newState.bookmarks.toSet()
            }
        }
    }

    fun onEvent(event: AppEvent) {
        _uiState.update { current ->
            when (event) {
                is AppEvent.SetTheme -> current.copy(isDarkTheme = event.dark)

                is AppEvent.Login ->
                    current.copy(isLoggedIn = true, userName = event.userName)

                AppEvent.Logout ->
                    current.copy(isLoggedIn = false, userName = null)

                is AppEvent.AddBookmark -> {
                    if (event.itemId in current.bookmarks) current
                    else current.copy(bookmarks = current.bookmarks + event.itemId)
                }

                is AppEvent.RemoveBookmark ->
                    current.copy(bookmarks = current.bookmarks - event.itemId)
            }
        }

        // after updating in-memory state, persist it
        persistState(_uiState.value)
    }
}
