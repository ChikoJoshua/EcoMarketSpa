package com.example.ecomarketapp.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecomarketapp.ui.pedido.PedidosScreen
import com.example.ecomarketapp.ui.producto.ProductosScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("EcoMarket 🌿") })
                }
            ) { padding ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "Bienvenido a EcoMarket",
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 22.sp
                        )
                        Text(
                            text = "Compra productos locales y sostenibles con impacto positivo.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    item {
                        Button(
                            onClick = { navController.navigate("productos") },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Ver Productos")
                        }
                    }

                    item {
                        Button(
                            onClick = { navController.navigate("pedidos") },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Mis Pedidos")
                        }
                    }
                }
            }
        }

        composable("productos") { ProductosScreen() }
        composable("pedidos") { PedidosScreen() }
    }
}
