package com.redrd.inventario_app_movil.intefaz.navegacion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redrd.inventario_app_movil.intefaz.pantallas.BienvenidaPantalla
import com.redrd.inventario_app_movil.intefaz.pantallas.BuscadorPantalla
import com.redrd.inventario_app_movil.intefaz.pantallas.ConfiguracionPantalla
import com.redrd.inventario_app_movil.intefaz.pantallas.InicioPantalla
import com.redrd.inventario_app_movil.intefaz.pantallas.ReportesPantalla

@Composable
fun GraficoNavegacion(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Pantallas.Splash.ruta,
        modifier = Modifier.padding(paddingValues) // Aplica el padding aquí
    ) {
        //Inicio de pantalla
        composable(Pantallas.Splash.ruta) { BienvenidaPantalla(navController) }

        // Rutas principales
        composable(Pantallas.Inicio.ruta) { InicioPantalla(navController) }
        composable(Pantallas.Buscar.ruta) { BuscadorPantalla(navController) }
        composable(Pantallas.Reportes.ruta) { ReportesPantalla(navController) }
        composable(Pantallas.Ajustes.ruta) { ConfiguracionPantalla(navController) }
    }
}

/*@Composable
fun GraficoNavegacion(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Pantallas.Inicio.ruta // La app inicia en la SplashScreen
    ) {
        composable(Pantallas.Splash.ruta) { BienvenidaPantalla(navController) }
        composable(Pantallas.Inicio.ruta){InicioPantalla(navController)}

        /*composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }*/
    }
}*/