package com.example.ecomarketapp.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ecomarketapp.ui.login.LoginScreen
import com.example.ecomarketapp.ui.main.HomeScreen
import com.example.ecomarketapp.ui.producto.ProductosScreen
import com.example.ecomarketapp.ui.carrito.CarritoScreen
import com.example.ecomarketapp.ui.pedidos.PedidosScreen
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: CarritoViewModel) {
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(onLoginSuccess = {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }

        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("productos") {
            ProductosScreen(
                viewModel = viewModel,
                onCarritoClick = { navController.navigate("carrito") }
            )
        }

        composable("carrito") {
            CarritoScreen(
                viewModel = viewModel,
                onVolverClick = { navController.popBackStack() }
            )
        }

        composable("pedidos") {
            PedidosScreen(
                viewModel = viewModel,
                onVolverClick = { navController.popBackStack() } // ✅ Aquí está el fix
            )
        }
    }
}
