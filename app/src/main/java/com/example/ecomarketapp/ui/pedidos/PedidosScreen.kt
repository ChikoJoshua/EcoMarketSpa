package com.example.ecomarketapp.ui.pedidos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidosScreen(viewModel: CarritoViewModel, onVolverClick: () -> Unit) {
    val pedidos = viewModel.pedidos

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis Pedidos") },
                navigationIcon = {
                    IconButton(onClick = onVolverClick) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            if (pedidos.isEmpty()) {
                Text("Aún no has realizado compras.")
            } else {
                pedidos.forEachIndexed { index, pedido ->
                    Text("Pedido ${index + 1}:", style = MaterialTheme.typography.titleMedium)
                    pedido.forEach { producto ->
                        Text("- ${producto.nombre}: $${producto.precio}")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
