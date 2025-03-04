package com.redrd.inventario_app_movil.interfaz.pantallas.registro

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel
import kotlinx.coroutines.delay

@Composable
fun registroArtefacto(navController: NavController, viewModel: InventarioVistaModel) {

    /*var nombre = remember { mutableStateOf("") }
    var codigo = remember { mutableStateOf("") }
    var descripcion = remember { mutableStateOf("") }
    var precioVenta = remember { mutableStateOf("") }
    var cantidad = remember { mutableStateOf("") }
    var fechaIngreso = remember { mutableStateOf("") }
    var imagen = remember { mutableStateOf("") }

    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registrar Artefacto",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = nombre.value,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = codigo.value,
            onValueChange = { codigo.value = it },
            label = { Text("Código") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descripcion.value,
            onValueChange = { descripcion.value = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = precioVenta.value,
            onValueChange = {
                if (it.all { char -> char.isDigit() || char == '.' }) {
                    precioVenta.value = it
                }
            },
            label = { Text("Precio de Venta") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cantidad.value,
            onValueChange = {
                if (it.all { char -> char.isDigit() }) {
                    cantidad.value = it
                }
            },
            label = { Text("Cantidad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fechaIngreso.value,
            onValueChange = { fechaIngreso.value = it },
            label = { Text("Fecha de Ingreso") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = imagen.value,
            onValueChange = { imagen.value = it },
            label = { Text("URL de Imagen (opcional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombre.isNotBlank() && codigo.isNotBlank() && precioVenta.isNotBlank() && cantidad.isNotBlank()) {
                    val artefacto = Artefacto(
                        nombre = nombre,
                        codigo = codigo,
                        descripcion = descripcion,
                        precioVenta = precioVenta.toDouble(),
                        cantidad = cantidad.toInt(),
                        fechaIngreso = fechaIngreso,
                        imagen = imagen.takeIf { it.isNotBlank() }
                    )

                    viewModel.agregarArtefacto(artefacto)
                    Toast.makeText(contexto, "Artefacto registrado", Toast.LENGTH_SHORT).show()
                    navController.popBackStack() // Vuelve a la pantalla anterior
                } else {
                    Toast.makeText(contexto, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Artefacto")
        }
    }*/

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Formulario de registro de Artefacto", fontSize = 32.sp, fontWeight = FontWeight.Bold)

    }
}
