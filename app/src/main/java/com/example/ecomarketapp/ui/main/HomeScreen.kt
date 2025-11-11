package com.example.ecomarketapp.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    usuario: String,
    onProductosClick: () -> Unit,
    onPedidosClick: () -> Unit,
    onCuentaClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bienvenido, $usuario") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("EcoMarket App", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onProductosClick, modifier = Modifier.fillMaxWidth()) {
                Text("Ver Productos")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onPedidosClick, modifier = Modifier.fillMaxWidth()) {
                Text("Ver Pedidos")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onCuentaClick, modifier = Modifier.fillMaxWidth()) {
                Text("Mi Cuenta / Carrito")
            }
        }
    }
}
