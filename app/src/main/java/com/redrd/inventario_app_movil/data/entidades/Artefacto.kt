package com.redrd.inventario_app_movil.data.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artefactos")
data class Artefacto(
    @PrimaryKey(autoGenerate = true)  val id: Int = 0,
    val nombre: String,
    val codigo: String,
   val descripcion: String,
    val precioVenta: Double,
   val cantidad: Int,
     val fechaIngreso: String,
     val imagen: String? = null
)