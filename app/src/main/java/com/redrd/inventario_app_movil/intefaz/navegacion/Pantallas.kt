package com.redrd.inventario_app_movil.intefaz.navegacion

import com.redrd.inventario_app_movil.R


sealed class Pantallas(val ruta: String, val icon: Int? = null, val selectedIcon: Int? = null) {
    object Splash : Pantallas("splash_screen");
    object Inicio : Pantallas("initio_screen", R.drawable.ic_home, R.drawable.ic_home_selected)
    object Buscar : Pantallas("search_screen", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground_selected)
    object Reportes: Pantallas("report_screen", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground_selected)
    object Ajustes: Pantallas("settings_screen", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground_selected)
}