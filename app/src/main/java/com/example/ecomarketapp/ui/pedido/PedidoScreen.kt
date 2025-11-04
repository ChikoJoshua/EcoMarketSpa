package com.example.ecomarketapp.ui.pedido

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidosScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mis Pedidos") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text("Aún no tienes pedidos realizados 🛒")
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = { /* Volver al home */ }) {
                Text("Explorar productos")
            }
        }
    }
}
