package com.example.caffeine.Navigation

sealed class AppDestination(val route: String) {
    object GhostScreen : AppDestination("GhostScreen")
    object CoffeeSelectionScreen : AppDestination("CoffeeSelectionScreen")
    object CustomCoffeeScreen : AppDestination("CustomCoffeeScreen")
    object LoadingScreen : AppDestination("LoadingScreen/{size}") {
        fun createRoute(size: String) = "LoadingScreen/$size"
    }
    object DoneScreen : AppDestination("DoneScreen")
    object SnackSelectionScreen : AppDestination("SnackSelectionScreen")

    object SnackDoneScreen : AppDestination("SnackDoneScreen/{snackId}") {
        fun createRoute(snackId: String) = "SnackDoneScreen/$snackId"
    }

}