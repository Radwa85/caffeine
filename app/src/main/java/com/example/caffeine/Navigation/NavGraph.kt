package com.example.caffeine.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.caffeine.ui.screen.snackselection.SnackSelectionScreen
import com.example.caffeine.screens.ghostScreen.GhostScreen
import com.example.caffeine.screens.coffeeType.CoffeeTypeScreen
import com.example.caffeine.screens.loading.LoadingScreen
import com.example.caffeine.screens.doneScreen.OrderDoneScreen
import com.example.caffeine.screens.customCoffee.CustomCoffeeScreen
import com.example.caffeine.screens.snackDone.SnackDoneScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.GhostScreen.route
    ) {
        composable(AppDestination.GhostScreen.route) {
            GhostScreen(navController)
        }
        composable(AppDestination.CoffeeSelectionScreen.route) {
            CoffeeTypeScreen(navController)
        }
        composable(
            route = "ProductScreen?title={title}",
            arguments = listOf(navArgument("title") { defaultValue = "Macchiato" })
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Macchiato"
            CustomCoffeeScreen(navController = navController, title = title)
        }

        composable(
            route = AppDestination.LoadingScreen.route
        ) { backStackEntry ->
            val selectedSize = backStackEntry.arguments?.getString("size") ?: "M"
            LoadingScreen(navController, selectedSize)
        }

        composable(AppDestination.DoneScreen.route) {
            OrderDoneScreen(navController)
        }
        composable(AppDestination.SnackSelectionScreen.route) {
            SnackSelectionScreen(navController = navController)
        }

        composable(
            route = AppDestination.SnackDoneScreen.route,
            arguments = listOf(navArgument("snackId") { defaultValue = "0" })
        ) { backStackEntry ->
            val snackId = backStackEntry.arguments?.getString("snackId") ?: "0"
            SnackDoneScreen(navController = navController, snackId = snackId)
        }

    }
}