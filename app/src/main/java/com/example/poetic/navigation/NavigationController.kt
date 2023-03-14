package com.example.poetic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.poetic.model.Poem
import com.example.poetic.views.*


@Composable
fun NavigationController(navController: NavHostController, randomPoems: List<Poem>, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Home(navController = navController, randomPoems = randomPoems)
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

