package com.example.poetic.bottomtabbar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.poetic.Favorites
import com.example.poetic.Search
import com.example.poetic.Settings
import com.example.poetic.views.Home


@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home()
        }

        composable(NavigationItem.Search.route) {
            Search()
        }

        composable(NavigationItem.Favorites.route) {
            Favorites()
        }

        composable(NavigationItem.Settings.route) {
            Settings()
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Favorites,
        NavigationItem.Settings)

    Scaffold(bottomBar = {
              BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
                  val navBackStackEntry by navController.currentBackStackEntryAsState()
                  val currentRoute =navBackStackEntry?.destination?.route

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
        NavigationController(navController = navController)
        val errorShutUp = it
    }
}