package com.redrd.inventario_app_movil.interfaz.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.data.Producto
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.data.entidades.Vehiculo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonEstilo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonGeneral
import com.redrd.inventario_app_movil.interfaz.componentes.MyInputButtomSearch
import com.redrd.inventario_app_movil.interfaz.componentes.TopBar
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel

@Composable
fun BuscadorPantalla(navController: NavController, viewModel: InventarioVistaModel){

    val artefactosState = viewModel.artefactos.observeAsState(emptyList())
    val vehiculosState = viewModel.vehiculos.observeAsState(emptyList())

    val artefactos = artefactosState.value
    val vehiculos = vehiculosState.value
    val productos = obtenerProductosUnificados(artefactos, vehiculos)

    var codigo = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar( title = "Buscar en Inventario", isClickable = false)

        MyInputButtomSearch("", codigo,
            "Buscar por nombre o codigo",
            true,
            "Escriba el nombre o codigo"){ }
        // Sección de Artefactos
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 🔹 Organiza en dos columnas
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // 🔹 Ocupa el espacio disponible sin empujar los botones fuera
        ){
            itemsIndexed(productos) { index, producto ->
                ProductoCard(producto)
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // 🔹 Agrega espacio antes de los botones
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonGeneral(texto = "Ordenar por Cantidad", estilo = BotonEstilo.OUTLINE){

            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonGeneral(texto = "Ordenar por Fecha de Ingreso", estilo = BotonEstilo.OUTLINE){

            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BotonGeneral(texto = "Ordenar por Precio", estilo = BotonEstilo.BLACK){

            }
        }
    }
}

