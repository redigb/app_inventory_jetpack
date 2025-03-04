package com.redrd.inventario_app_movil.intefaz.pantallas

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
import com.redrd.inventario_app_movil.intefaz.navegacion.Pantallas
import kotlinx.coroutines.delay

@Composable
fun BienvenidaPantalla(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000) // Espera 2 segundos
        navController.navigate(Pantallas.Inicio.ruta) // Ir a Inicio
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "StockFlow", fontSize = 32.sp, fontWeight = FontWeight.Bold)
    }
}
