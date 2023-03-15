package com.example.poetic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.poetic.model.Datasource
import com.example.poetic.model.Poem
import com.example.poetic.views.*


@Composable
fun NavigationController(navController: NavHostController, modifier: Modifier = Modifier) {
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

        composable(
            DetailNavItem.Detail.route + "/{title}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            DetailScreen(title)
        }
    }
}

