package com.example.cursobasicoandroid.core

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.cursobasicoandroid.features.MenuScreen
import com.example.cursobasicoandroid.features.imc.ImcResultScreen
import com.example.cursobasicoandroid.features.imc.ImcScreen

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(Menu)

    NavDisplay(backStack = backStack, entryProvider = entryProvider{
        entry<Menu> {
            MenuScreen(onImcSelected = {backStack.add(IMC)})
        }

        entry<IMC> {
            ImcScreen(onResultSelected = { backStack.add(IMCResult(it))})
        }

        entry<IMCResult> { data ->
            ImcResultScreen(data.result, onBackSelected = { backStack.removeLastOrNull()})
        }
    })
}