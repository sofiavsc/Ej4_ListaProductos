package com.example.ej4_listas.listas

data class Categoria(
    val nombre: String,
    val imagen: Int
)

data class Producto(
    val nombre: String,
    val precio: String,
    val imagen: Int,
    val envioGratis: Boolean,
    val descuento: Boolean
)