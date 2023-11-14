package com.kusitms.presentation.ui.login.member


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsSnackField
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.RightArrow
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavHostController, viewModel: SignInViewModel) {
    val major by viewModel.major.observeAsState("")
    val email by viewModel.email.observeAsState("")
    val phoneNum by viewModel.phoneNum.observeAsState("")
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

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
                        onClick = { navController.popBackStack() },

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
            Box(
                modifier= Modifier
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
            ) {
                SignInMember1(
                    navController = navController,
                    major = major,
                    email = email,
                    phoneNum = phoneNum,
                    onMajorChange = viewModel::updateMajor,
                    onEmailChange = viewModel::updateEmail,
                    onPhoneNumChange = viewModel::updatePhoneNum
                )
            }
        }
    )
}

@Composable
fun SignInMember1(
    navController: NavHostController,
    major: String,
    email: String,
    phoneNum: String,
    onMajorChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneNumChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey800),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {

        TitleColumn(major = major, email = email, phoneNum = phoneNum, onMajorChange = onMajorChange, onEmailChange=onEmailChange, onPhoneNumChange= onPhoneNumChange)

        ButtonRowSignIn1(text1 = "이전으로", text2 = "다음으로", navController = navController, KusitmsColorPalette.current.Grey600, KusitmsColorPalette.current.Grey600,
            onNextClick = { navController.navigate(NavRoutes.LoginMemberScreen.route)}
        )
    }

}

@Composable
fun TitleColumn(
    major: String,
    email: String,
    phoneNum: String,
    onMajorChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPhoneNumChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey800)
            .height(840.dp),
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
            TextColumn1()
        }
        Spacer(modifier = Modifier.height(20.dp))
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

        //전공
        Text(text = stringResource(id = R.string.signin_member_caption1_2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsInputField(
            text = R.string.signin_member_hint1_1,
            value = major,
            onValueChange = onMajorChange)
            if(major.length > 20) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "최대 20자까지 입력할 수 있어요",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400
                )
            }

        Spacer(modifier = Modifier.height(24.dp))

        //파트 선택
        Text(text = stringResource(id = R.string.signin_member_caption1_3), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsSnackField(text = R.string.signin_member_hint1_2, onSnackClick = {

        })

        //관심 카테고리
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_4), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsSnackField(text = R.string.signin_member_hint1_3, onSnackClick = {})

        //연락처
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(id = R.string.signin_member_title2), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)

        //이메일
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_5), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsInputField(text = R.string.signin_member_hint1_4, value = email, onValueChange = onEmailChange)

        //전화번호
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_6), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsInputField(text = R.string.signin_member_hint1_5, value = phoneNum, onValueChange = onPhoneNumChange)

    }
}

@Composable
fun TextColumn1() {
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

@Composable
fun ButtonRowSignIn1(
    text1:String,
    text2:String,
    navController: NavController,
    color1: Color,
    color2: Color,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(start = 20.dp, top = 8.dp, end = 20.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = color1),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text1, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey400)
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = {
                onNextClick()
                Log.d("Click", "go to SignIn")
            },
            colors = ButtonDefaults.buttonColors(containerColor = color2),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text2, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}

@Composable
fun ShowPartSnack(scaffoldState: ScaffoldState) {
    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
    }
}



@Preview
@Composable
fun SignIn1Preview() {
    SignInScreen(navController = rememberNavController(), viewModel = SignInViewModel())
}