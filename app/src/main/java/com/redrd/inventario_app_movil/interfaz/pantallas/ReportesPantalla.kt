package com.redrd.inventario_app_movil.interfaz.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.interfaz.componentes.BotonEstilo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonGeneral
import com.redrd.inventario_app_movil.interfaz.componentes.TopBar
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas

@Composable
fun ReportesPantalla(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar(title = "Reportes de Inventario", isClickable = false)

        Text( text = "Registro de Artefactos y Vehiculos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp) // Espaciado uniforme
        )
        Text( text = "Salida de Artefactos y Vehiculos",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp) // Espaciado uniforme
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp), // Espacio antes de los botones
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Reduce separación
        ) {
            Box(modifier = Modifier.weight(1f)) {
                BotonGeneral(texto = "Exportar a PDF", estilo = BotonEstilo.OUTLINE) { }
            }
            Box(modifier = Modifier.weight(1f)) {
                BotonGeneral(texto = "Exportar a Excel", estilo = BotonEstilo.BLACK) { }
            }
        }
    }

}