package com.redrd.inventario_app_movil.interfaz.navegacion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redrd.inventario_app_movil.interfaz.pantallas.BienvenidaPantalla
import com.redrd.inventario_app_movil.interfaz.pantallas.BuscadorPantalla
import com.redrd.inventario_app_movil.interfaz.pantallas.ConfiguracionPantalla
import com.redrd.inventario_app_movil.interfaz.pantallas.InventarioPantalla
import com.redrd.inventario_app_movil.interfaz.pantallas.ReportesPantalla
import com.redrd.inventario_app_movil.interfaz.pantallas.registro.registroArtefacto
import com.redrd.inventario_app_movil.interfaz.pantallas.registro.registroVehiculo
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel

@Composable
fun GraficoNavegacion(navController: NavHostController, paddingValues: PaddingValues) {

    val viewModel: InventarioVistaModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Pantallas.Splash.ruta,
        modifier = Modifier.padding(paddingValues)
    ) {
        //Inicio de pantalla
        composable(Pantallas.Splash.ruta) { BienvenidaPantalla(navController) }

        // Rutas principales
        composable(Pantallas.Inicio.ruta) { InventarioPantalla(navController, viewModel) }
        // ---->  Ruta segundatia a la principal
        composable(Pantallas.RegistroArtefacto.ruta) { registroArtefacto(navController) }
        composable(Pantallas.RegistroVehiculo.ruta) { registroVehiculo(navController) }


        composable(Pantallas.Buscar.ruta) { BuscadorPantalla(navController) }
        composable(Pantallas.Reportes.ruta) { ReportesPantalla(navController) }
        composable(Pantallas.Ajustes.ruta) { ConfiguracionPantalla(navController) }

    }
}