package com.example.kabar.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

// Context extension for DataStore
val Context.appDataStore by preferencesDataStore(name = "app_prefs")

object AppPrefsKeys {
    val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
    val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    val USER_NAME = stringPreferencesKey("user_name")
    val BOOKMARKS = stringSetPreferencesKey("bookmarks")
}
