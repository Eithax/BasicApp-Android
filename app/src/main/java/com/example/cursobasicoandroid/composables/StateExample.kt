package com.example.cursobasicoandroid.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CounterScreen(modifier: Modifier) {
    /**
     * rememberSaveable funciona igual que el remember pero guardando la información al regenerar la vista tras destruirla.
     */
    var counter by rememberSaveable() { mutableStateOf(23) }
    var counter2 by rememberSaveable() { mutableStateOf(14) }
    var name by rememberSaveable() { mutableStateOf("") }

    /**
     * El estado de un composable siempre debe estar en el padre.
     * El estado se actualiza porque el hijo le manda la acción.
     * Esto se denomina State Hoisting
     */

    Column(modifier) {
        Counter(counter=counter, onIncrement = {counter++})
        Counter(counter=counter2, onIncrement = {counter2++})
        TextFieldCounter(name = name, onValueChange = {name = it})
    }

}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    counter: Int,
    onIncrement: () -> Unit
) {
    Column(modifier = modifier.padding(30.dp)) {
        Button(onClick = { onIncrement() }) {
            Text("Sumar")
        }
        Text("Pulsaciones: $counter")
    }
}

@Composable
fun TextFieldCounter(
    modifier: Modifier = Modifier,
    name: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = name,
        onValueChange = {onValueChange(it)},
        label = {Text("Example")}
    )
}