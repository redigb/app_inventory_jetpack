package com.redrd.inventario_app_movil.interfaz.navegacion

import com.redrd.inventario_app_movil.R


sealed class Pantallas(val ruta: String, val icon: Int? = null) {
    object Splash : Pantallas("splash_screen");
    object Inventario : Pantallas("Inventario_screen", R.drawable.ic_inventary)
    object Buscar : Pantallas("Buscar_screen", R.drawable.ic_search)
    object Reportes: Pantallas("Reportes_screen", R.drawable.ic_report)
    object Ajustes: Pantallas("Ajustes_screen", R.drawable.ic_settings)

    object RegistroArtefacto: Pantallas("registroArtefacto_screen")
    object RegistroVehiculo: Pantallas("registroVehiculo_screen")
}