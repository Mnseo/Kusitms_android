package com.kusitms.presentation.common.theme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.RightArrow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KusitmsScaffoldNonScroll(
    topbarText: String,
    navController:NavHostController? = null,
    content: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = topbarText,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = KusitmsTypo.current.SubTitle2_Semibold,
                        color = KusitmsColorPalette.current.Grey100
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = KusitmsColorPalette.current.Grey900,
                    titleContentColor = KusitmsColorPalette.current.Grey100,
                    navigationIconContentColor = KusitmsColorPalette.current.Grey400
                ),
                navigationIcon = {
                    if(navController != null) {
                        IconButton(
                            onClick = { navController.popBackStack() },
                            ) {
                            Icon(
                                imageVector = RightArrow.vector,
                                contentDescription = "Localized description",
                            )
                        }
                    }
                }
            )
        },
        content = { innerPadding ->
            content()
        }
    )
}
