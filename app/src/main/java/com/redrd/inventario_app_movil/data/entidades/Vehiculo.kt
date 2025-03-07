package com.redrd.inventario_app_movil.data.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "vehiculos")
data class Vehiculo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val serieModelo: String,
    val descripcion: String,
    val precioVenta: Double,
    val cantidad: Int,
    val fechaIngreso: String,
    //val fecha: Date,
    val imagen: String? = null
)