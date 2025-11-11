package com.example.ecomarketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.ecomarketapp.ui.navegacion.NavGraph
import com.example.ecomarketapp.ui.theme.EcoMarketAppTheme
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoMarketAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    // ✅ Crear el NavController y el ViewModel
                    val navController = rememberNavController()
                    val viewModel: CarritoViewModel by viewModels()

                    // ✅ Llamar correctamente al NavGraph
                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}
