package com.redrd.inventario_app_movil.interfaz.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.redrd.inventario_app_movil.interfaz.componentes.BotonEstilo
import com.redrd.inventario_app_movil.interfaz.componentes.BotonGeneral
import com.redrd.inventario_app_movil.interfaz.componentes.MyInput
import com.redrd.inventario_app_movil.interfaz.componentes.TopBar

@Composable
fun ConfiguracionPantalla(navController: NavController){
    var nombreEmpresa = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar( title = "Configuracion", isClickable = false)

        MyInput("Nombre de la Empresa",
            nombreEmpresa,
            "Ingrese el nombre de la Empresa",
            false
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) { BotonGeneral(texto = "Actualizar Cambios",
            estilo = BotonEstilo.BLACK){}
        }
    }
}