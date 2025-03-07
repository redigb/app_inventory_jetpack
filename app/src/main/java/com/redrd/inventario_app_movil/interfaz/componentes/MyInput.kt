package com.redrd.inventario_app_movil.interfaz.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInput(
    title: String,
    textState: MutableState<String>,
    placeholder: String,
    showBottomText: Boolean = false,
    textBottom: String = ""
){
    Column(modifier = Modifier.padding(12.dp)) {
        Text( text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(placeholder, color = Color.Gray) },
            modifier = Modifier.fillMaxWidth()
                .height(45.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,  // Borde negro al hacer clic
                unfocusedBorderColor = Color.Gray  // Borde gris cuando no está enfocado
            )
        )
        if (showBottomText) {
            Text(
                text = textBottom,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 2.dp, top = 8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInputIcon(
    title: String,
    textState: MutableState<String>,
    placeholder: String,
    trailingIcon: ImageVector,
    showBottomText: Boolean = false,
    textBottom: String
) {

    Column(modifier = Modifier.padding(12.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(placeholder, color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,  // Borde negro al hacer clic
                unfocusedBorderColor = Color.Gray  // Borde gris cuando no está enfocado
            ),
            trailingIcon = {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = "Icono_puesto",
                        tint = Color.Gray
                    )
            }
        )
        if (showBottomText) {
            Text(
                text = textBottom,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 2.dp, top = 8.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInputButtomSearch(
    title: String,
    textState: MutableState<String>,
    placeholder: String,
    showBottomText: Boolean = false,
    textBottom: String = "",
    onClick: () -> Unit
) {
    Column(modifier = Modifier.padding(12.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(placeholder, color = Color.Gray) },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF363434),  // Borde negro al hacer clic
                unfocusedBorderColor = Color.Gray  // Borde gris cuando no está enfocado
            ),
            trailingIcon = {
                IconButton(
                    onClick = onClick,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color.Black, Color.DarkGray)
                            )
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color.White
                    )
                }
            }
        )

        if (showBottomText) {
            Text(
                text = textBottom,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 2.dp, top = 8.dp)
            )
        }
    }
}
