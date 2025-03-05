package com.redrd.inventario_app_movil.vistaModelo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.redrd.inventario_app_movil.data.AppDatabase
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.data.entidades.Vehiculo
import com.redrd.inventario_app_movil.data.repository.InventarioRepository
import kotlinx.coroutines.launch

class InventarioVistaModel(application: Application) : AndroidViewModel(application) {

    private val repository: InventarioRepository
    val artefactos: LiveData<List<Artefacto>>
    val vehiculos: LiveData<List<Vehiculo>>

    init {
        val db = AppDatabase.getDatabase(application)
        repository = InventarioRepository(db.artefactoDao(), db.vehiculoDao())
        artefactos = repository.artefactos
        vehiculos = repository.vehiculos
    }

    fun agregarArtefacto(artefacto: Artefacto) = viewModelScope.launch {
        repository.agregarArtefacto(artefacto)
    }

    fun agregarVehiculo(vehiculo: Vehiculo) = viewModelScope.launch {
        repository.agregarVehiculo(vehiculo)
    }


}