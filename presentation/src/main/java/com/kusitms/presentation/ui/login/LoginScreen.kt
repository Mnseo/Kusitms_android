package com.kusitms.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTheme

@Composable
fun Login(
    navController: NavHostController
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Black),
            horizontalAlignment = Alignment.CenterHorizontally
            {
                androidx.compose.foundation.layout.Spacer(modifier = )
                    
                })
        ) {
            
        }
}

@Preview
@Composable
fun LoginPreview() {
    Login(navController = rememberNavController())
}