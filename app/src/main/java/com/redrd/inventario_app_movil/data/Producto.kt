package com.redrd.inventario_app_movil.data

sealed class Producto {
    abstract val id: Int
    abstract val nombre: String
    abstract val cantidad: Int
    abstract val imagen: String?
    abstract val fechaIngreso: String

    data class ArtefactoProducto(
        override val id: Int,
        override val nombre: String,
        override val cantidad: Int,
        override val imagen: String?,
        override val fechaIngreso: String
    ) : Producto()

    data class VehiculoProducto(
        override val id: Int,
        override val nombre: String,
        override val cantidad: Int,
        override val imagen: String?,
        override val fechaIngreso: String
    ) : Producto()
}