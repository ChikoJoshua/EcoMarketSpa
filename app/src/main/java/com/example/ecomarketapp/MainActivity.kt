package com.example.ecomarketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecomarketapp.ui.navegacion.NavGraph
import com.example.ecomarketapp.ui.viewmodel.CarritoViewModel
import com.example.ecomarketapp.ui.theme.EcoMarketAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoMarketAppTheme {
                val carritoViewModel: CarritoViewModel = viewModel()
                NavGraph(viewModel = carritoViewModel)
            }
        }
    }
}
