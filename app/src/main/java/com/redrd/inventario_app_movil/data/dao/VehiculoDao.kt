package com.redrd.inventario_app_movil.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.redrd.inventario_app_movil.data.entidades.Vehiculo

interface VehiculoDao {
    @Insert
    suspend fun insertar(vehiculo: Vehiculo)

    @Query("SELECT * FROM vehiculos")
    fun obtenerTodos(): LiveData<List<Vehiculo>>
}