package com.example.cursobasicoandroid.features.imc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursobasicoandroid.features.imc.composables.CounterSelector
import com.example.cursobasicoandroid.features.imc.composables.GenderSelector
import com.example.cursobasicoandroid.features.imc.composables.HeightSelector
import com.example.cursobasicoandroid.ui.theme.AppBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImcScreen(onResultSelected: (Float) -> Unit) {

    var isMaleSelected by remember{ mutableStateOf(true) }
    var height by remember{ mutableStateOf(160f) }
    var weight by remember{ mutableStateOf(80) }
    var age by remember{ mutableStateOf(30) }

    Scaffold(
        containerColor = AppBackground,
        topBar = {
            TopAppBar(title = {Text("IMC Calculator")})
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            GenderSelector(isMaleSelected = isMaleSelected) { isMaleSelected = it }
            HeightSelector(height, {height = it})
            CounterSelector(
                age = age,
                weight = weight,
                onPlusAgeSelected = { age++ },
                onMinusAgeSelected = { age-- },
                onPlusWeightSelected = { weight++ },
                onMinusWeightSelected = { weight-- }
            )
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                    .fillMaxWidth()
                    .height(64.dp),
                onClick = {
                    val result = calculateBMI(height = height, weight = weight)
                    onResultSelected(result)
                },
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Calcular", fontSize = 30.sp)
            }
        }
    }


}

fun calculateBMI(
    height: Float,
    weight: Int
): Float {
    val heightInMeters = height / 100
    return weight / (heightInMeters*heightInMeters)
}