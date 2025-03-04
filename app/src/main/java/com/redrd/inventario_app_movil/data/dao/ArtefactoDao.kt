package com.redrd.inventario_app_movil.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.redrd.inventario_app_movil.data.entidades.Artefacto

interface ArtefactoDao {
    @Insert
    suspend fun insertar(artefacto: Artefacto)

    @Query("SELECT * FROM artefactos")
    fun obtenerTodos(): LiveData<List<Artefacto>>
}