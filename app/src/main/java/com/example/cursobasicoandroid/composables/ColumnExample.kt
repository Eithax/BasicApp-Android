package com.example.cursobasicoandroid.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ColumnExample() {
    Column() {
        Text("Text 1")
        Text("Text 2")
        Text("Text 3")
        Text("Text 4")
        Text("Text 5")
    }
}