package com.example.cursobasicoandroid.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextFieldExample() {

    /**
     * El remember se usa porque las vistas de compose se regeneran y el valor de la variable se perdería.
     * Lo que hace el remember es recordar esa información.
     */
    // var inputText = ""
    var inputText = remember() { mutableStateOf("") }

    /**
     * Si no se quiere usar el .value constantemente, se puede poner by en lugar de =
     *
     * var inputText by remember() { mutableStateOf("") }
     *
     * Para ello, se deben importar el setValue y getValue. Así, se puede usar el estado inputText sin tener que poner el .value
     */

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            label = { Text("Write your answer") })
    }
}