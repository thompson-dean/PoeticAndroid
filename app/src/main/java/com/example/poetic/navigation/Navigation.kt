package com.example.poetic.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Favorites,
        NavigationItem.Settings
    )



    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface, elevation = 0.dp) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach {
                BottomNavigationItem(selected = currentRoute == it.route,
                    label = {
                        Text(
                            text = it.label,
                            color = if(currentRoute == it.route) MaterialTheme.colors.onSurface else Color.Gray
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = null,
                            tint = if(currentRoute == it.route) MaterialTheme.colors.onSurface else Color.Gray)
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.graph.startDestinationRoute?.let {
                                navController.popBackStack(it, true)
                            }

                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }
                        }

                    }
                )
            }
        }
    }) {
        NavigationController(
            navController = navController,
            modifier = Modifier.padding(it))
    }
}