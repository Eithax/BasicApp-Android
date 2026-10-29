package com.example.cursobasicoandroid.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursobasicoandroid.R

@Preview
@Composable
fun ImageExample() {
    Image(painter = painterResource(R.drawable.cyberpunk_2077_logo), contentDescription = "Cyberpunk 2077 logo")
}