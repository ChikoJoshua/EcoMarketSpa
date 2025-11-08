package com.example.ecomarketapp.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecomarketapp.ui.main.HomeScreen
import com.example.ecomarketapp.ui.producto.ProductosScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("productos") { ProductosScreen() }
    }
}
