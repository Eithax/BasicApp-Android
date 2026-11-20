package com.example.cursobasicoandroid.core

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.cursobasicoandroid.features.MenuScreen
import com.example.cursobasicoandroid.features.imc.ImcResultScreen
import com.example.cursobasicoandroid.features.imc.ImcScreen
import com.example.cursobasicoandroid.features.settings.SettingsScreen

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(Menu)

    NavDisplay(backStack = backStack, entryProvider = entryProvider{
        entry<Menu> {
            MenuScreen(
                onImcSelected = {backStack.add(IMC)},
                onSettingsSelected = {backStack.add(Settings)}
            )
        }

        entry<IMC> {
            ImcScreen(
                onResultSelected = { backStack.add(IMCResult(it)) },
                onBackSelected = { backStack.removeLastOrNull() }
            )
        }

        entry<IMCResult> { data ->
            ImcResultScreen(data.result, onBackSelected = { backStack.removeLastOrNull()})
        }

        entry<Settings> {
            SettingsScreen( onBackSelected = {
                backStack.removeLastOrNull()}
            )
        }
    })
}