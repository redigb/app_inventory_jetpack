package com.redrd.inventario_app_movil.interfaz.pantallas


import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.redrd.inventario_app_movil.R
import com.redrd.inventario_app_movil.data.Producto
import com.redrd.inventario_app_movil.data.entidades.Artefacto
import com.redrd.inventario_app_movil.data.entidades.Vehiculo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonEstilo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonGeneral
import com.redrd.inventario_app_movil.interfaz.componentes.TopBar
import com.redrd.inventario_app_movil.interfaz.navegacion.Pantallas
import com.redrd.inventario_app_movil.vistaModelo.InventarioVistaModel

@Composable
fun InventarioPantalla(navController: NavController, viewModel: InventarioVistaModel) {

    val artefactosState = viewModel.artefactos.observeAsState(emptyList())
    val vehiculosState = viewModel.vehiculos.observeAsState(emptyList())

    val artefactos = artefactosState.value
    val vehiculos = vehiculosState.value
    val productos = obtenerProductosUnificados(artefactos, vehiculos)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar( title = "Inventario", isClickable = false)
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonGeneral(texto = "Añadir Artefacto", estilo = BotonEstilo.OUTLINE){
                navController.navigate(Pantallas.RegistroArtefacto.ruta)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            BotonGeneral(texto = "Añadir Vehículo", estilo = BotonEstilo.BLACK,){
                navController.navigate(Pantallas.RegistroVehiculo.ruta)
            }
        }
    }
}

@Composable
fun ProductoCard(producto: Producto) {
    val isRandomLayout = remember { (0..1).random() == 1 } // Alternar entre diseños

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Etiqueta del tipo de producto
            Text(
                text = if (producto is Producto.ArtefactoProducto) "Artefacto" else "Vehiculo",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))

            if (isRandomLayout) {
                // Diseño 1: Imagen primero, luego datos
                ProductoImagen(producto.imagen)
                Spacer(modifier = Modifier.height(8.dp))
                ProductoInfo(producto)
            } else {
                // Diseño 2: Datos primero, luego imagen
                ProductoInfo(producto)
                Spacer(modifier = Modifier.height(8.dp))
                ProductoImagen(producto.imagen)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Acciones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "🛒", fontSize = 20.sp)
                Text(text = "📦", fontSize = 20.sp)
                Text(text = "📊", fontSize = 20.sp)
            }
        }
    }
}

/*@Composable
fun ProductoImagen(imagen: String?) {
    Image(
        painter = painterResource(id = R.drawable.placeholder),
        contentDescription = "Imagen del producto",
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}*/

@Composable
fun ProductoImagen(imagen: String?) {
    val context = LocalContext.current
    val isValidUrl = remember(imagen) {
        !imagen.isNullOrBlank() && Patterns.WEB_URL.matcher(imagen).matches()
    }

    if (isValidUrl) {
        AsyncImage(
            model = imagen,
            contentDescription = "Imagen del producto",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder)
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = "Imagen por defecto",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProductoInfo(producto: Producto) {
    Text(text = producto.nombre, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    Text(text = "Stock: ${producto.cantidad} unidades", fontSize = 14.sp, color = Color.Gray)
}


/*@Composable
fun ProductoImagen(imagen: String?) {
    Image(
        painter = painterResource(id = R.drawable.placeholder),
        contentDescription = "Imagen del producto",


@Composable
fun ProductoCard(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = if (producto is Producto.ArtefactoProducto) "Artefacto" else "Vehiculo",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.background(Color.LightGray).padding(4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "Imagen del producto",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = producto.nombre, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "In stock: ${producto.cantidad} units", fontSize = 14.sp, color = Color.Gray)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "🛒")
                Text(text = "📦")
                Text(text = "📊")
            }
        }
    }
}*/

@Composable
fun obtenerProductosUnificados(
    artefactos: List<Artefacto>,
    vehiculos: List<Vehiculo>
): List<Producto> {
    return remember(artefactos, vehiculos) {
        val artefactosMapped = artefactos.map { artefacto ->
            Producto.ArtefactoProducto(
                id = artefacto.id,
                nombre = artefacto.nombre,
                cantidad = artefacto.cantidad,
                imagen = artefacto.imagen,
                fechaIngreso = artefacto.fechaIngreso // Ahora usamos fechaIngreso
            )
        }
        val vehiculosMapped = vehiculos.map { vehiculo ->
            Producto.VehiculoProducto(
                id = vehiculo.id,
                nombre = vehiculo.nombre,
                cantidad = vehiculo.cantidad,
                imagen = vehiculo.imagen,
                fechaIngreso = vehiculo.fechaIngreso // Ahora usamos fechaIngreso
            )
        }
        (artefactosMapped + vehiculosMapped).sortedByDescending { it.id }
    }
}

/*@Composable
fun obtenerProductosUnificados(
    artefactos: List<Artefacto>,
    vehiculos: List<Vehiculo>
): List<Producto> {
    return remember(artefactos, vehiculos) {
        val artefactosMapped = artefactos.map { artefacto ->
            Producto.ArtefactoProducto(
                id = artefacto.id,
                nombre = artefacto.nombre,
                cantidad = artefacto.cantidad,
                imagen = artefacto.imagen
            )
        }
        val vehiculosMapped = vehiculos.map { vehiculo ->
            Producto.VehiculoProducto(
                id = vehiculo.id,
                nombre = vehiculo.nombre,
                cantidad = vehiculo.cantidad,
                imagen = vehiculo.imagen
            )
        }
        artefactosMapped + vehiculosMapped
    }
}*/



