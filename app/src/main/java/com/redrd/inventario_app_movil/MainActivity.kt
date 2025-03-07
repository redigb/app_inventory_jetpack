package com.redrd.inventario_app_movil

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.redrd.inventario_app_movil.interfaz.navegacion.GraficoNavegacion
import com.redrd.inventario_app_movil.interfaz.navegacion.NavegacionBotton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Config - splash screen
       installSplashScreen()
        setContent {
            // InventoryScreen()
           MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavegacionBotton(navController) } // Llamada correcta
    ) { paddingValues -> // Recibe el padding de Scaffold
        GraficoNavegacion(navController = navController, paddingValues = paddingValues)
    }
}

//@Preview
@Composable
fun InventoryScreen() {
    var selectedTab = remember { mutableStateOf("INCOMING") }
    val items = listOf("Laptop", "Mouse", "Keyboard", "Monitor")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6)) // Fondo general
            .padding(16.dp)
    ) {
        // Tabs
        Row(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabButton("INCOMING", selectedTab.value) { selectedTab.value = it }
            TabButton("OUTCOMING", selectedTab.value) { selectedTab.value = it }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Import / Export Buttons
        /*Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            ActionButton("IMPORT FROM EXCEL")
            ActionButton("EXPORT FROM EXCEL")
        }*/

        Spacer(modifier = Modifier.height(5.dp))

        // List of items
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(items) { index, item ->
                InventoryItem(index, item)
            }
        }
    }
}

@Composable
fun ActionButton(label: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(label, color = Color.White)
    }
}

@Composable
fun InventoryItem(index: Int, item: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "#$index - $item", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "Available", fontSize = 14.sp, color = Color.Gray)
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
            ) {
                Text("Details", color = Color.White)
            }
        }
    }
}

@Composable
fun TabButton(label: String, selectedTab: String, onSelect: (String) -> Unit) {
    Button(
        onClick = { onSelect(label) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedTab == label) Color(0xFF3B82F6) else Color(0xFFE5E7EB)
        ),
        modifier = Modifier.fillMaxWidth().padding(4.dp)
    ) {
        Text(label, color = if (selectedTab == label) Color.White else Color.Black)
    }
}
