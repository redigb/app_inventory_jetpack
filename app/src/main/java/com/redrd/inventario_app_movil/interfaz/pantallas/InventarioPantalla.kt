package com.redrd.inventario_app_movil.interfaz.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel

@Composable
fun InventarioPantalla(navController: NavController, viewModel: InventarioVistaModel) {

    val artefactosState = viewModel.artefactos.observeAsState(emptyList())
    val vehiculosState = viewModel.vehiculos.observeAsState(emptyList())

    val artefactos = artefactosState.value
    val vehiculos = vehiculosState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Inventario",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Sección de Artefactos
        Text(
            text = "Artefactos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn(modifier = Modifier.height(200.dp)) {
            itemsIndexed(artefactos) { index, item -> // 🔹 Usar "item" en vez de "artefacto"
                ProductoCard(item.nombre, item.cantidad)
            }
        }

        // Sección de Vehículos
        Text(
            text = "Vehículos",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn(modifier = Modifier.height(200.dp)) {
            itemsIndexed(vehiculos) { index, item -> // 🔹 Hacerlo uniforme con artefactos
                ProductoCard(item.nombre, item.cantidad)
            }
        }

        // Botones para agregar elementos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonAgregar("Añadir Artefacto") {
                navController.navigate(Pantallas.RegistroArtefacto.ruta)
            }
            BotonAgregar("Añadir Vehículo") {
                navController.navigate(Pantallas.RegistroVehiculo.ruta)
            }
        }
    }
}

@Composable
fun ProductoCard(nombre: String, stock: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart, // Puedes cambiar el icono según el tipo
                contentDescription = "Icono de producto",
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = nombre, fontWeight = FontWeight.Bold)
                Text(text = "Stock: $stock unidades", color = Color.Gray)
            }
        }
    }
}


@Composable
fun BotonAgregar(texto: String, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = onClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(texto)
        }
    }
}
