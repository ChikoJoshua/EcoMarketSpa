package com.example.ecomarketapp.ui.carrito

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(
    viewModel: CarritoViewModel,
    onVolverClick: () -> Unit
) {
    val carrito = viewModel.carrito

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tu Carrito") },
                navigationIcon = {
                    IconButton(onClick = onVolverClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },
        bottomBar = {
            if (carrito.isNotEmpty()) {
                Button(
                    onClick = { viewModel.finalizarCompra() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Finalizar Compra")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            if (carrito.isEmpty()) {
                Text("Tu carrito está vacío.")
            } else {
                carrito.forEach { producto ->
                    Text("- ${producto.nombre}: $${producto.precio}")
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Total: $${carrito.sumOf { it.precio }}",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
