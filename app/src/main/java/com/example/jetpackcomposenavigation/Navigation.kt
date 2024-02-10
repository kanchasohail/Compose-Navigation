package com.example.jetpackcomposenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposenavigation.layout.DetailScreen
import com.example.jetpackcomposenavigation.layout.MainScreen
import com.example.jetpackcomposenavigation.layout.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Sohail"
                    nullable = true
                }
            )) { entry ->
            DetailScreen(name = entry.arguments?.getString("name"))
        }
    }
}