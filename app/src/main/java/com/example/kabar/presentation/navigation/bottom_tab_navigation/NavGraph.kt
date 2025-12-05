package com.example.kabar.presentation.navigation.bottom_tab_navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.kabar.presentation.screens.*
import com.example.kabar.presentation.screens.HomeScreen.Bookmark
import com.example.kabar.presentation.screens.HomeScreen.Explore
import com.example.kabar.presentation.screens.HomeScreen.HomeScreen
import com.example.kabar.presentation.screens.Profile.Profile
import com.example.kabar.presentation.state.AppViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    appViewModel: AppViewModel,
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") { HomeScreen(appViewModel = appViewModel, modifier = Modifier) }
        composable("explore") { Explore(appViewModel = appViewModel) }
        composable("bookmark") { Bookmark(appViewModel = appViewModel) }
        composable("profile") {
            Profile(
                isDarkTheme = isDarkTheme,
                onThemeToggle = onThemeToggle,
                appViewModel = appViewModel
            )
        }

    }
}
