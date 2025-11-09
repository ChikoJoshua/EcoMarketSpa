package com.example.ecomarketapp.ui.carrito

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.ui.producto.Producto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(
    carrito: List<Producto>,
    onVaciarCarrito: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("🛒 Tu Carrito") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (carrito.isEmpty()) {
                Text("Tu carrito está vacío 😢", style = MaterialTheme.typography.bodyLarge)
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(carrito) { producto ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(Modifier.padding(12.dp)) {
                                Text(producto.nombre, style = MaterialTheme.typography.titleMedium)
                                Text("Precio: $${producto.precio}")
                            }
                        }
                    }
                }

                Divider(Modifier.padding(vertical = 8.dp))

                val total = carrito.sumOf { it.precio }
                Text("Total: $${"%.0f".format(total)}", style = MaterialTheme.typography.titleLarge)

                Button(
                    onClick = onVaciarCarrito,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text("Vaciar Carrito")
                }
            }
        }
    }
}
