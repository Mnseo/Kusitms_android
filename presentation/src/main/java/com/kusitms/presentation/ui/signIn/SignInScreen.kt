package com.kusitms.presentation.ui.login.member


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.RightArrow
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.signIn.ButtonRow
import com.kusitms.presentation.ui.signIn.KusitmsInputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "프로필 설정",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = KusitmsTypo.current.SubTitle2_Semibold,
                        color = KusitmsColorPalette.current.Grey100
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = KusitmsColorPalette.current.Grey800,
                    titleContentColor = KusitmsColorPalette.current.Grey100,
                    navigationIconContentColor = KusitmsColorPalette.current.Grey400
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { /* doSomething() */ },

                    ) {
                        Icon(
                            imageVector = RightArrow.vector,
                            contentDescription = "Localized description",
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Box(modifier=Modifier.padding(innerPadding)) {
                SignInMember1(navController = navController)
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
            .background(KusitmsColorPalette.current.Grey800),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {

        TitleColumn()

        ButtonRow(text1 = "이전으로", text2 = "다음으로", navController = navController)

    }

}

@Composable
fun InputFieldColumn(
    major: String,
    email: String,
    phoneNum: String,
    onMajorChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onPhoneNumChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Grey800)
            .height(350.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        Text(text = stringResource(id = R.string.signin_member_title1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        Spacer(modifier = Modifier.height(28.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_1), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = KusitmsColorPalette.current.Grey500,
                shape = RoundedCornerShape(16.dp)
            ),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "이채연",
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400,
                modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsInputField(text = R.string.signin_member_hint1_1, value = major, onValueChange = onMajorChange)


    }
}

@Composable
fun TitleColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey800)
            .height(500.dp),
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
        Spacer(modifier = Modifier.height(20.dp))
        InputFieldColumn()
        
    }
}

@Composable
fun TextColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Black)
            .height(64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Text(text = stringResource(id = R.string.text_column_1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.text_column_2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub2)

    }
}




@Preview
@Composable
fun SignIn1Preview() {
    SignInScreen(navController = rememberNavController())
}