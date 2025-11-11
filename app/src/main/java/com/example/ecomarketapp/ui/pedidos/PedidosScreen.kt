package com.example.ecomarketapp.ui.pedidos

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidosScreen(viewModel: CarritoViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mis Pedidos") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            if (viewModel.carrito.isEmpty()) {
                item { Text("Aún no tienes pedidos realizados.") }
            } else {
                items(viewModel.carrito) { producto ->
                    Text("- ${producto.nombre} ($${producto.precio})")
                }
            }
        }
    }
}
