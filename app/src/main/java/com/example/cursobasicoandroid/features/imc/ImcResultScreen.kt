package com.example.cursobasicoandroid.features.imc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcResultScreen(result: Float, onBackSelected: () -> Unit) {

    val textColor: Color = getBMIColor(result)

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Analizando...")
            })
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp)
        ) {
            Text("Tu resultado", fontSize = 48.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                modifier = Modifier.fillMaxWidth().weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        getBMICategory(result),
                        color = textColor,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "%.2f".format(result),
                        color = textColor,
                        fontSize = 74.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        getBMIDescription(result),
                        color = textColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = { onBackSelected() }
            ) {
                Text("Recalcular", fontSize = 28.sp)
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}

fun getBMICategory(bmi: Float): String {
    return when {
        bmi < 18.5f -> "Bajo peso"
        bmi < 25f -> "Normal"
        bmi < 30f -> "Sobrepeso"
        else -> "Obesidad"
    }
}

fun getBMIDescription(bmi: Float): String {
    return when {
        bmi < 18.5f -> "Estás por debajo del peso recomendado."
        bmi < 25f -> "Estás en el peso óptimo."
        bmi < 30f -> "Estás por encima del peso recomendado."
        else -> "Acude al médico urgentemente, tu salud está en riesgo."
    }
}

fun getBMIColor(bmi: Float): Color {
    return when {
        bmi < 18.5f -> Color.Blue
        bmi < 25f -> Color(0xFF09AF44)
        bmi < 30f -> Color(0xFFDE8B01)
        else -> Color.Red
    }
}