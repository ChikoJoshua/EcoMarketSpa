package com.example.ecomarketapp.ui.producto

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.R
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(
    viewModel: CarritoViewModel,
    onCarritoClick: () -> Unit
) {
    val productos = listOf(
        Producto(1, "Aceite de Oliva", 7900.0, R.drawable.aceite),
        Producto(2, "Café Orgánico", 6500.0, R.drawable.cafe),
        Producto(3, "Granola Natural", 4200.0, R.drawable.granola),
        Producto(4, "Harina Integral", 2800.0, R.drawable.harina),
        Producto(5, "Leche Vegetal", 3600.0, R.drawable.leche),
        Producto(6, "Miel Orgánica", 4500.0, R.drawable.miel),
        Producto(7, "Pan Artesanal", 2500.0, R.drawable.pan),
        Producto(8, "Té Verde", 3100.0, R.drawable.te),
        Producto(9, "Yogurt Natural", 3900.0, R.drawable.yogurt)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productos EcoMarket") },
                actions = {
                    // Icono del carrito con contador
                    BadgedBox(
                        badge = {
                            if (viewModel.carrito.isNotEmpty()) {
                                Badge { Text("${viewModel.carrito.size}") }
                            }
                        }
                    ) {
                        IconButton(onClick = onCarritoClick) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrito"
                            )
                        }
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = producto.nombre,
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = producto.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = "$${producto.precio}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                        Button(onClick = { viewModel.agregarAlCarrito(producto) }) {
                            Text("Agregar")
                        }
                    }
                }
            }
        }
    }
}

private fun CarritoViewModel.agregarAlCarrito(producto: Producto) {}
