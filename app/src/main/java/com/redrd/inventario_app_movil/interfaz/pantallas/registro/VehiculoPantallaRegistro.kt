package com.redrd.inventario_app_movil.interfaz.pantallas.registro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel
import kotlinx.coroutines.delay

@Composable
fun registroVehiculo(navController: NavController, viewModel: InventarioVistaModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Formulario de registro de Vehiculo", fontSize = 32.sp, fontWeight = FontWeight.Bold)

    }
}
