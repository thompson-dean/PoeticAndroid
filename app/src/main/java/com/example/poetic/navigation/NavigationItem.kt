package com.example.poetic.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home: NavigationItem(
        route = "home",
        label = "Home",
        icon = Icons.Default.Home
    )

    object Search: NavigationItem(
        route = "search",
        label = "Search",
        icon = Icons.Default.Search
    )

    object Favorites: NavigationItem(
        route = "favorites",
        label = "Favorites",
        icon = Icons.Default.Star
    )

    object Settings: NavigationItem(
        route = "settings",
        label = "Settings",
        icon = Icons.Default.Settings
    )
}

sealed class DetailNavItem(
    val route: String
    ) {
    object Detail: DetailNavItem(
        route = "detail"
    )
}
