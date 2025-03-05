package com.redrd.inventario_app_movil.interfaz.componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BotonGeneral(
    texto: String,
    estilo: BotonEstilo,
    onClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            shape = RoundedCornerShape(10.dp),
            elevation = if (estilo == BotonEstilo.BLACK) {
                ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 6.dp
                )
            } else {
                null // No elevación para Outline
            },
            colors = when (estilo) {
                BotonEstilo.BLACK -> ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
                BotonEstilo.OUTLINE -> ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            },
            border = if (estilo == BotonEstilo.OUTLINE) {
                BorderStroke(2.dp, Color.Black)
            } else {
                null
            },
            onClick = onClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(texto)
        }
    }
}


enum class BotonEstilo {
    OUTLINE, BLACK
}