package com.example.ecomarketapp.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ecomarketapp.ui.producto.Producto

class CarritoViewModel : ViewModel() {
    val carrito = mutableStateListOf<Producto>()
    val pedidos = mutableStateListOf<List<Producto>>() // historial de compras

    fun agregarAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    fun finalizarCompra() {
        if (carrito.isNotEmpty()) {
            pedidos.add(carrito.toList()) // guarda la compra
            carrito.clear() // vacía el carrito
        }
    }
}
