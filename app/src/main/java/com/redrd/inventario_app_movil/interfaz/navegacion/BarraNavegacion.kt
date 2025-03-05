package com.redrd.inventario_app_movil.interfaz.navegacion

import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.redrd.inventario_app_movil.R
import com.redrd.inventario_app_movil.ui.theme.Sky


@Composable
fun NavegacionBotton(navController: NavController) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val screens = listOf(
        Pantallas.Inicio,
        Pantallas.Buscar,
        Pantallas.Reportes,
        Pantallas.Ajustes
    )

   if (currentRoute != Pantallas.Splash.ruta) {
       Box(
           modifier = Modifier
               .fillMaxWidth()
               .height(110.dp)
               .background(Color.White, shape = menuBarShape())
               .padding(bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()) // 🔥 Ajuste dinámico
       ) {
           HorizontalDivider(
               color = Color.Gray.copy(alpha = 0.2f), // Cambia el color según lo necesites
               thickness = 2.dp,
               modifier = Modifier.align(Alignment.TopCenter)
           )

           Row(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(bottom = 10.dp),
               horizontalArrangement = Arrangement.SpaceEvenly,
               verticalAlignment = Alignment.CenterVertically
           ) {
               screens.forEach { screen ->
                   BottomBarItem(
                       screen = screen,
                       currentScreen = screens.find { it.ruta == currentRoute },
                       onNavigateTo = { navController.navigate(screen.ruta) }
                   )
               }
           }
       }
    }
}


@Composable
fun RowScope.BottomBarItem(
    screen: Pantallas,
    currentScreen: Pantallas?,
    onNavigateTo: (Pantallas) -> Unit
) {
    val isSelected = screen.ruta == currentScreen?.ruta
    val animatedColor = animateColorAsState(if (isSelected) Sky else Color.Gray)

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable { onNavigateTo(screen) }
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = screen.icon!!),
            contentDescription = null,
            tint = animatedColor.value,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = screen.ruta.replace("_screen", "").replaceFirstChar { it.uppercase() },
            fontSize = 14.sp,
            color = animatedColor.value,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}
private fun menuBarShape() = GenericShape { size, _ ->
    reset()

    val curveWidth = size.width * 0.3f
    val curveHeight = size.height * 1.8f

    moveTo(0f, size.height * 0.4f)
    lineTo(size.width / 2 - curveWidth, size.height * 0.4f)

    cubicTo(
        size.width / 2 - curveWidth * 0.8f, size.height * 0.4f,
        size.width / 2 - curveWidth * 0.6f, curveHeight,
        size.width / 2, curveHeight
    )

    cubicTo(
        size.width / 2 + curveWidth * 0.6f, curveHeight,
        size.width / 2 + curveWidth * 0.8f, size.height * 0.4f,
        size.width / 2 + curveWidth, size.height * 0.4f
    )

    lineTo(size.width, size.height * 0.4f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)
    close()
}


