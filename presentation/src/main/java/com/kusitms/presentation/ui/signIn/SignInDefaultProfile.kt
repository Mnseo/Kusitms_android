package com.kusitms.presentation.ui.login.member


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitmsSnackField
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.PartBottomSheet
import com.kusitms.presentation.ui.signIn.SignInFixedInput
import com.kusitms.presentation.ui.signIn.component.LikeCatergoryBottomSheet
import kotlinx.coroutines.launch


@Composable
fun SignInDefaultProfile(viewModel: SignInViewModel, navController: NavHostController) {
    val major by viewModel.major.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadLoginMemberProfile()
    }

    KusitmsScaffoldNonScroll(topbarText = "프로필 설정", navController = navController) {
        SignInMember1(
            navController = navController,
            viewModel = viewModel,
            major = major,
            onMajorChange = viewModel::updateMajor,
        )
    }
}

@Composable
fun SignInMember1(
    navController: NavHostController,
    viewModel: SignInViewModel,
    major: String,
    onMajorChange: (String) -> Unit,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {

        TitleColumn(major = major, onMajorChange = onMajorChange, viewModel = viewModel)

        ButtonRowSignIn1(text1 = "이전으로", text2 = "다음으로", navController = navController, KusitmsColorPalette.current.Grey600, KusitmsColorPalette.current.Grey600,
            onNextClick = { navController.navigate(NavRoutes.SignInAdditionalProfile.route)},
            viewModel = viewModel
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun TitleColumn(
    major: String,
    onMajorChange: (String) -> Unit,
    viewModel: SignInViewModel
) {
    val email by viewModel.email.collectAsState()
    val phoneNum by viewModel.phoneNum.collectAsState()
    val name by viewModel.name.collectAsState()
    val selectedPart by viewModel.selectedPart.collectAsState()
    val interests by viewModel.interests.collectAsState()
    val likeCategoryText = if (interests.isNotEmpty()) {
        interests.joinToString(", ") { it.content }
    } else {
        stringResource(id = R.string.signin_member_hint1_3)
    }

    var isOpenPartBottomSheet by remember { mutableStateOf(false) }
    var isOpenLikeCategoryBottomSheet by remember { mutableStateOf(false) }


    if(isOpenPartBottomSheet){
        PartBottomSheet(
            viewModel = viewModel,
            isOpenPartBottomSheet
        ){
            isOpenPartBottomSheet = it
            if(!selectedPart.isNullOrBlank()) {
                isOpenPartBottomSheet = false
            }
        }
    }

    if(isOpenLikeCategoryBottomSheet){
        LikeCatergoryBottomSheet(
            viewModel = viewModel,
            isOpenLikeCategoryBottomSheet)
        {
            isOpenLikeCategoryBottomSheet = it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey900)
            .height(910.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {
        KusitmsMarginVerticalSpacer(size = 70)
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
        SignInFixedInput(modelValue = name)
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

        Text(text = stringResource(id = R.string.signin_member_caption1_3) , style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        (if (!selectedPart.isNullOrEmpty()) {
            selectedPart
        } else {
            stringResource(R.string.signin_member_hint1_2)
        })?.let {
            KusitmsSnackField(
                text = it,
                onSnackClick = {
                    isOpenPartBottomSheet = true
                }
            )
        }

        //관심 카테고리
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_4), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        KusitmsSnackField(
            text = likeCategoryText,
            onSnackClick = {
                isOpenLikeCategoryBottomSheet = true
            }
        )


        Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(id = R.string.signin_member_title2), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        //이메일
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_5), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        SignInFixedInput(modelValue = email)

        //전화번호
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.signin_member_caption1_6), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        Spacer(modifier = Modifier.height(5.dp))
        SignInFixedInput(modelValue = phoneNum)

    }
}

@Composable
fun TextColumn1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Grey900)
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
    onNextClick: () -> Unit,
    viewModel: SignInViewModel
) {
    val validateFields by viewModel.isAllFieldsValid.collectAsState()
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
                if(validateFields) {
                    onNextClick()
                    Log.d("Click_SignInDefault", "go to SignIn")
                    Log.d("Click_SignInDefault", validateFields.toString())
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = color2),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text2, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}


