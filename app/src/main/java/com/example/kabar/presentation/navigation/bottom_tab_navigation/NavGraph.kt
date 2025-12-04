package com.example.kabar.presentation.navigation.bottom_tab_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.kabar.presentation.screens.*
import com.example.kabar.presentation.screens.HomeScreen.Bookmark
import com.example.kabar.presentation.screens.HomeScreen.Explore
import com.example.kabar.presentation.screens.HomeScreen.HomeScreen
import com.example.kabar.presentation.screens.Profile.Profile

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") { HomeScreen() }
        composable("explore") { Explore() }
        composable("bookmark") { Bookmark() }
        composable("profile") {
            Profile(
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle
            )
        }

    }
}
