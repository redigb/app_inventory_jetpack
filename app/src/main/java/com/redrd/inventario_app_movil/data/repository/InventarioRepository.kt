package com.redrd.inventario_app_movil.data.repository

import androidx.lifecycle.LiveData
import com.redrd.inventario_app_movil.data.dao.ArtefactoDao
import com.redrd.inventario_app_movil.data.dao.VehiculoDao
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.data.entidades.Vehiculo

class InventarioRepository(private val artefactoDao: ArtefactoDao, private val vehiculoDao: VehiculoDao) {

    val artefactos: LiveData<List<Artefacto>> = artefactoDao.obtenerTodos()
    val vehiculos: LiveData<List<Vehiculo>> = vehiculoDao.obtenerTodos()

    // Por temas de tiempo no añadi las validaciones.
    suspend fun agregarArtefacto(artefacto: Artefacto) {
        artefactoDao.insertar(artefacto)
    }

    suspend fun agregarVehiculo(vehiculo: Vehiculo) {
        vehiculoDao.insertar(vehiculo)
    }
}