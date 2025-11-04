package com.example.ecomarketapp.ui.producto

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecomarketapp.R

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen() {
    val productos = listOf(
        Producto(1, "Miel Orgánica", 4500.0, R.drawable.ic_launcher_foreground),
        Producto(2, "Harina Integral", 2800.0, R.drawable.ic_launcher_foreground),
        Producto(3, "Aceite de Oliva", 7900.0, R.drawable.ic_launcher_foreground)
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Productos EcoMarket") })
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
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = producto.imagen),
                            contentDescription = producto.nombre,
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text(text = producto.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(text = "$${producto.precio}", style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        }
    }
}
