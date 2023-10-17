package com.kusitms.presentation.ui.login.member


import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.signIn.ButtonRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavHostController, slideInAlpha: Float) {
    val targetOffsetX = if (slideIn) 0f else -300f
    val targetAlpha = if (slideIn) 1f else 0f

    val offsetX by animateFloatAsState(
        targetValue = targetOffsetX,
        animationSpec = tween(durationMillis = 300)
    )

    val alpha by animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = tween(durationMillis = 300)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Simple TopAppBar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val list = (0..75).map { it.toString() }
                items(count = list.size) {
                    Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                                .graphicsLayer(
                                    translationX = if (slideInAlpha == 1f) 0f else offsetX,
                                    alpha = slideInAlpha * alpha
                                )
                            ) {
                        Text(
                            text = list[it],
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun SignInMember1(
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {

        TitleColumn()
        
        Spacer(modifier = Modifier.height(56.dp))

        Text(text = stringResource(id = R.string.signin_member_title1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)

        ButtonRow(text1 = "이전으로", text2 = "다음으로", navController = navController)

    }

}

@Composable
fun TitleColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            StudyIcon.drawStudyIcon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            TextColumn()
        }
        
    }
}

@Composable
fun TextColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Black)
            .height(109.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Text(text = stringResource(id = R.string.text_column_1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.text_column_2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub2)

    }
}

@Composable
fun inputField(hint : String, maxlength: Int? = null) {
    Column {
        var textState by remember { mutableStateOf("")}
        val maxLength = maxlength
        val originColor = KusitmsColorPalette.current.Grey700
        val changeColor = KusitmsColorPalette.current.Main500

        Text(
            text = stringResource(id = R.string.signin_member_caption1_2),
            style = KusitmsTypo.current.Caption1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            color = KusitmsColorPalette.current.Grey400
        )

//        TextField(
//            modifier = Modifier.fillMaxWidth(),
//            value = textState,
//            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(backgroundColor = originColor),
//        )

    }
}




@Preview
@Composable
fun SignIn1Preview() {
    SignInMember1(navController = rememberNavController())
}