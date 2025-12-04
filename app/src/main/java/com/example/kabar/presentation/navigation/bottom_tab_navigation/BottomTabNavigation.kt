package com.example.kabar.presentation.navigation.bottom_tab_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomTabNavigation(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {

    val navController = rememberNavController()

    val navItems = listOf(
        BottomTabNavItem("home", "Home", Icons.Default.Home),
        BottomTabNavItem("explore", "Explore", Icons.Default.LocationOn),
        BottomTabNavItem("bookmark", "Bookmark", Icons.Default.Add),
        BottomTabNavItem("profile", "Profile", Icons.Default.AccountCircle),
    )

    // Use theme colors instead of hard-coded values
    val bgColor = MaterialTheme.colorScheme.background
    val activeColor = MaterialTheme.colorScheme.primary
    val inactiveColor = MaterialTheme.colorScheme.secondary

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = bgColor,
                contentColor = inactiveColor
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                navItems.forEach { item ->
                    val isSelected = currentRoute == item.route

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo("home")
                                launchSingleTop = true
                            }
                        },

                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = if (isSelected) activeColor else inactiveColor
                            )
                        },

                        label = {
                            Text(
                                text = item.label,
                                color = if (isSelected) activeColor else inactiveColor
                            )
                        },

                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = activeColor,
                            selectedTextColor = activeColor,
                            unselectedIconColor = inactiveColor,
                            unselectedTextColor = inactiveColor,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        BottomNavGraph(
            navController = navController,
            isDarkTheme = isDarkTheme,
            onThemeToggle = onThemeToggle
        )
    }
}

