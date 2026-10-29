package com.example.cursobasicoandroid.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ButtonExample() {
    /**
    Button(onClick = {
        println("Hola")
    },
        content = {}) { }

     Esta última lambda (content) no hace falta ponerla en los parámetros, es lo que se pone entre las llaves finales
    */

    Button(onClick = { print("Hello") }) {
        Text("Pulsame")
    }
}