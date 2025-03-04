package com.redrd.inventario_app_movil.intefaz.navegacion

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState



/*@Composable
fun NavegacionBotton(navController: NavController) {
    val currentRoute = navController
        .currentBackStackEntryAsState().value?.destination?.route

    val screens = listOf(
        Pantallas.Inicio,
        Pantallas.Buscar,
        Pantallas.Reportes,
        Pantallas.Ajustes
    )

    if (currentRoute != Pantallas.Splash.ruta) { // No mostramos la barra en Splash
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White, shape = menuBarShape())
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
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
}*/


@Composable
fun RowScope.BottomBarItem(
    screen: Pantallas,
    currentScreen: Pantallas?,
    onNavigateTo: (Pantallas) -> Unit
) {
    val selected = screen.ruta == currentScreen?.ruta

    Box(
        Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(if (selected) Color.White else Color.Transparent, shape = if (selected) curvedShape() else RectangleShape)

            .clickable { onNavigateTo(screen) }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = if (selected) screen.selectedIcon!! else screen.icon!!),
            contentDescription = null,
            tint = if (selected) Color.Blue else Color.Gray
        )
    }
}

private fun curvedShape() = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)

/*private fun curvedShape() = GenericShape { size, _ ->
    reset()

    moveTo(0f, 0f)

    val width = size.width
    val height = size.height * 0.8f

    val curveHeight = 15f
    val curveWidth = width * 0.5f

    lineTo(width / 2 - curveWidth, 0f)

    cubicTo(
        width / 2 - curveWidth / 2, curveHeight,
        width / 2 + curveWidth / 2, curveHeight,
        width / 2 + curveWidth, 0f
    )

    lineTo(width, 0f)
    lineTo(width, height)
    lineTo(0f, height)

    close()
}*/



/*@Composable
fun NavegacionBotton(navController: NavController) {
    val currentRoute = navController
        .currentBackStackEntryAsState().value?.destination?.route

    val screens = listOf(
        Pantallas.Inicio,
        Pantallas.Buscar,
        Pantallas.Reportes,
        Pantallas.Ajustes
    )

    if (currentRoute != Pantallas.Splash.ruta) { // No mostramos la barra en Splash
        Box {
            // Fondo curvado
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(Color.White, menuBarShape())
                    .align(Alignment.BottomCenter)
            )

            // Botón flotante
            Column(
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                FloatingActionButton(
                    shape = CircleShape,
                    containerColor = Color.White,
                    onClick = { /* Acción */ },
                    modifier = Modifier.size(64.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Nuevo")
                }
                Spacer(modifier = Modifier.height(30.dp))
            }

            // Íconos de navegación
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .align(Alignment.BottomCenter)
            ) {
                screens.forEach { screen ->
                    BottomBarItem(
                        screen,
                        currentScreen = screens.find { it.ruta == currentRoute },
                        onNavigateTo = { navController.navigate(it.ruta) }
                    )
                }
            }
        }
    }
}*/

/*
@Composable
fun RowScope.BottomBarItem(
    screen: Pantallas,
    currentScreen: Pantallas?,
    onNavigateTo: (Pantallas) -> Unit
) {
    val selected = screen.ruta == currentScreen?.ruta

    Box(
        Modifier
            .selectable(
                selected = selected,
                onClick = { onNavigateTo(screen) },
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(radius = 32.dp)
            )
            .fillMaxHeight()
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = if (selected) screen.selectedIcon!! else screen.icon!!),
            contentDescription = null,
            tint = if (selected) Color.Blue else Color.Gray,
            modifier = Modifier
                .clickable { onNavigateTo(screen) }
                .padding(8.dp)
        )
    }
}*/




private fun menuBarShape() = GenericShape { size, _ ->
    reset()

    moveTo(0f, 0f)

    val width = 150f
    val height = 90f

    val point1 = 75f
    val point2 = 85f

    lineTo(size.width / 2 - width, 0f)

    cubicTo(
        size.width / 2 - point1, 0f,
        size.width / 2 - point2, height,
        size.width / 2, height
    )

    cubicTo(
        size.width / 2 + point2, height,
        size.width / 2 + point1, 0f,
        size.width / 2 + width, 0f
    )

    lineTo(size.width / 2 + width, 0f)

    lineTo(size.width, 0f)
    lineTo(size.width, size.height)
    lineTo(0f, size.height)

    close()
}