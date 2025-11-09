package com.example.ecomarketapp.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ecomarketapp.ui.producto.Producto

class CarritoViewModel : ViewModel() {
    val carrito = mutableStateListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        carrito.add(producto)
    }

    fun eliminarProducto(producto: Producto) {
        carrito.remove(producto)
    }

    fun vaciarCarrito() {
        carrito.clear()
    }
}
