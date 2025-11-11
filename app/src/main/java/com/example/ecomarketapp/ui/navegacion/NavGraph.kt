package com.example.ecomarketapp.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecomarketapp.ui.login.LoginScreen
import com.example.ecomarketapp.ui.main.HomeScreen
import com.example.ecomarketapp.ui.producto.ProductosScreen
import com.example.ecomarketapp.ui.pedidos.PedidosScreen
import com.example.ecomarketapp.ui.carrito.CarritoScreen
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@Composable
fun NavGraph(viewModel: CarritoViewModel) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = { usuario ->
                navController.navigate("home/$usuario")
            })
        }
        composable("home/{usuario}") { backStackEntry ->
            val usuario = backStackEntry.arguments?.getString("usuario") ?: "Usuario"
            HomeScreen(
                usuario = usuario,
                onProductosClick = { navController.navigate("productos") },
                onPedidosClick = { navController.navigate("pedidos") },
                onCuentaClick = { navController.navigate("carrito") }
            )
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
            PedidosScreen(viewModel = viewModel)
        }
    }
}
