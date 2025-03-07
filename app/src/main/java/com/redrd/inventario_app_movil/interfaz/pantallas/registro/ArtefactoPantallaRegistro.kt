package com.redrd.inventario_app_movil.interfaz.pantallas.registro

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.interfaz.componentes.BotonEstilo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonGeneral
import com.redrd.inventario_app_movil.interfaz.componentes.TopBar
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun registroArtefacto(navController: NavController, viewModel: InventarioVistaModel) {

    var nombre = remember { mutableStateOf("") }
    var codigo = remember { mutableStateOf("") }
    var descripcion = remember { mutableStateOf("") }
    var precioVenta = remember { mutableStateOf("") }
    var cantidad = remember { mutableStateOf("") }

    val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val fechaActual = formatoFecha.format(Date()) // Obtener la fecha actual formateada
    val fechaIngreso = remember { mutableStateOf(fechaActual) }

    var imagen = remember { mutableStateOf("") }

    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(title = "Registrar Artefacto", isClickable = true){
            navController.navigate(Pantallas.Inventario.ruta)
        }

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

        BotonGeneral("Guardar Artefacto", BotonEstilo.BLACK){
            if (nombre.value.isNotBlank() && codigo.value.isNotBlank() && precioVenta.value.isNotBlank() && cantidad.value.isNotBlank()) {
                val artefacto = Artefacto(
                    nombre = nombre.value,
                    codigo = codigo.value,
                    descripcion = descripcion.value,
                    precioVenta = precioVenta.value.toDouble(),
                    cantidad = cantidad.value.toInt(),
                    fechaIngreso = fechaIngreso.value,
                    imagen = imagen.value.takeIf { it.isNotBlank() }
                )

                viewModel.agregarArtefacto(artefacto)
                Toast.makeText(contexto, "Artefacto registrado", Toast.LENGTH_SHORT).show()
                navController.popBackStack() // Vuelve a la pantalla anterior
            } else {
                Toast.makeText(contexto, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
