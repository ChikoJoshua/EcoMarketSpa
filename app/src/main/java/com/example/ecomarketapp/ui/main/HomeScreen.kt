package com.example.ecomarketapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecomarketapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("EcoMarket App") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Imagen del logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo EcoMarket",
                modifier = Modifier
                    .size(180.dp)
                    .padding(bottom = 24.dp)
            )

            Text(
                "Bienvenido a EcoMarket",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("productos") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Productos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navController.navigate("pedidos") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Mis Pedidos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* más adelante se puede hacer cerrar sesión */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mi Cuenta")
            }
        }
    }
}
