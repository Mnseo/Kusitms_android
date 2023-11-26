package com.kusitms.presentation.ui.setting


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingScreen(navController: NavHostController) {

}

@Preview
@Composable
fun SettingPreview() {
    SettingScreen(navController = rememberNavController())
}