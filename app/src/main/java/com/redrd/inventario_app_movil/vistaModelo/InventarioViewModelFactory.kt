package com.redrd.inventario_app_movil.vistaModelo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InventarioViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventarioVistaModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventarioVistaModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
