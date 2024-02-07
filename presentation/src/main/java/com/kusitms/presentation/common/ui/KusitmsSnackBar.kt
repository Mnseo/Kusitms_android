package com.kusitms.presentation.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette


@Composable
fun KusitmsSnackBar(
    text:String,
    content: @Composable () -> Unit
): @Composable (SnackbarHostState) -> Unit =
    { snackbarHostState: SnackbarHostState ->
        SnackbarHost(
            hostState = snackbarHostState
        ) { snackbarData ->
            Box(modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .background(color = KusitmsColorPalette.current.Grey600)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    content
                }
            }

        }
    }

