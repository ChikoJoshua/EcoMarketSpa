package com.example.ecomarketapp.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecomarketapp.ui.carrito.CarritoScreen
import com.example.ecomarketapp.ui.main.HomeScreen
import com.example.ecomarketapp.ui.producto.ProductosScreen
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val carritoViewModel: CarritoViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("productos") {
            ProductosScreen(
                viewModel = carritoViewModel,
                onCarritoClick = { navController.navigate("carrito") }
            )
        }
        composable("carrito") {
            CarritoScreen(
                viewModel = carritoViewModel,
                onVolverClick = { navController.popBackStack() }
            )
        }
    }
}
