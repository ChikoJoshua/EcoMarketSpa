package com.example.ecomarketapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ecomarketapp.ui.producto.Producto

data class Pedido(
    val id: Int,
    val productos: List<Producto>,
    val total: Double
)

class CarritoViewModel : ViewModel() {
    private var contadorPedidos = 1
    val carrito = mutableListOf<Producto>()
    val pedidos = mutableListOf<Pedido>()

    fun agregarAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    fun finalizarCompra() {
        if (carrito.isNotEmpty()) {
            val nuevoPedido = Pedido(
                id = contadorPedidos++,
                productos = carrito.toList(),
                total = carrito.sumOf { it.precio }
            )
            pedidos.add(nuevoPedido)
            carrito.clear()
        }
    }
}
