package com.example.poetic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.poetic.DetailScreen
import com.example.poetic.Favorites
import com.example.poetic.Search
import com.example.poetic.Settings
import com.example.poetic.views.Home


@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home(navController = navController)
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

        composable(DetailNavItem.Detail.route) {
            DetailScreen(randomString = "Details")
        }
    }
}

