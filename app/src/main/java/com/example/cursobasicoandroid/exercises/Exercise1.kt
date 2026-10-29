package com.example.cursobasicoandroid.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Exercise1() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)
            .background(Color.Cyan)
            .fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }
        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.weight(1f)
                .background(Color.Red)
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text("Ejemplo 2")
            }
            Box(modifier = Modifier.weight(1f)
                .background(Color.Green)
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text("Ejemplo 3")
            }
        }
        Box(modifier = Modifier.weight(1f)
            .background(Color.Magenta)
            .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter) {
            Text("Ejemplo 4")
        }
    }
}