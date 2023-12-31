package com.kusitms.presentation.ui.signIn

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.ButtonRow
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel

import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.*
import com.kusitms.presentation.ui.signIn.component.LinkBottomSheet



@Composable
fun SignInAdditionalProfile(viewModel: SignInViewModel, navController: NavHostController) {

    KusitmsScaffoldNonScroll(topbarText = "프로필 설정", navController = navController) {
        SignIn2Member(viewModel = viewModel, navController = navController)
    }
}


@Composable
fun SignIn2Member(viewModel: SignInViewModel,navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        Title2Column()
        PhotoColumn(viewModel)
        KusitmsMarginVerticalSpacer(size = 10)
        introColumn(viewModel)
        KusitmsMarginVerticalSpacer(size = 4)
        LinkColumn(viewModel)
        Spacer(modifier = Modifier.weight(1f))
        ButtonRow("이전으로", "가입완료", navController, KusitmsColorPalette.current.Grey600,KusitmsColorPalette.current.Main500,
            onNextClick = { navController.navigate(NavRoutes.SignInProfileComplete.route)})
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun PhotoColumn(viewModel: SignInViewModel) {
    val context = LocalContext.current
    val imageUri by viewModel.selectedImage.collectAsState() // This should be a Uri? in your ViewModel

    val imagePickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            viewModel.updateSelectedImage(uri) // Update the ViewModel with the Uri
        }
    }

    Box(
        modifier = Modifier
            .width(96.dp)
            .height(96.dp)
            .background(color = Color(0xFF20232D), shape = RoundedCornerShape(size = 12.dp))
            .clickable {
                imagePickerLauncher.launch("image/*")
            }
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImagePhoto(imageUri)
        }
    }
}

@Composable
fun Title2Column() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey900)
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
                    .width(24.dp))
            TextColumn()
        }
    }
}

@Composable
fun TextColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Grey900)
            .height(109.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

    ) {
        Text(text = stringResource(id = R.string.signin2_text1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        Text(text = stringResource(id = R.string.signin2_text2), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Sub1)
    }
}

@Composable
fun introColumn(viewModel: SignInViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey900)
            .height(186.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,

    ) {
        Text(text = stringResource(id = R.string.signin2_title1), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
        introTextField(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun introTextField(viewModel: SignInViewModel) {
    val maxLength = 100
    val textState by viewModel.introduce.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(KusitmsColorPalette.current.Grey600, shape = RoundedCornerShape(16.dp))
        ) {
            TextField(
                value = textState,
                onValueChange = {
                    if(it.length <= maxLength) { viewModel.updateIntroduce(it) }
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = KusitmsColorPalette.current.Grey600,
                    cursorColor = KusitmsColorPalette.current.Grey600,
                    disabledLabelColor = KusitmsColorPalette.current.Grey600,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = {Text(stringResource(id = R.string.signin2_placeholder1), style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.Grey400 )}
            )
        }
        Text(text = "${textState.length}/$maxLength", style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
    }
}

@Composable
fun LinkColumn(viewModel: SignInViewModel) {
    val currentLength by viewModel.linkCount.collectAsState()
    val maxLength = 4
    var isOpenLinkBottomSheet by remember { mutableStateOf(false)}

    if(isOpenLinkBottomSheet) {
        LinkBottomSheet(
            viewModel, isOpenLinkBottomSheet
        ) {
            isOpenLinkBottomSheet = it
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(KusitmsColorPalette.current.Grey900),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier =
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Text 클릭 시 길이를 1씩 증가
            Text(
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey300,
                text = stringResource(id = R.string.signin2_title2),
            )
            LinkRow1(viewModel, maxLength)
        }
        Spacer(modifier = Modifier .height(14.dp))
        repeat(currentLength) {
            LinkRow2(onClick =  {isOpenLinkBottomSheet = true}, viewModel = viewModel)
        }
    }

}

@Composable
fun LinkRow1(viewModel: SignInViewModel, maxLength: Int) {
    val linkCount by viewModel.linkCount.collectAsState()
    Row(
        modifier = Modifier
            .width(125.dp)
            .height(36.dp)
            .background(
                color = KusitmsColorPalette.current.Grey900,
                shape = RoundedCornerShape(size = 8.dp)
            ),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        plusIcon()
        Text(
            style= KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey300,
            text = "추가하기${linkCount}/${maxLength}",
            modifier = Modifier.clickable {
                if (linkCount< maxLength) { // 4개 이상 추가되지 않도록 제한
                    viewModel.linkCountUp()
                }
            }
        )
    }
}

@Composable
fun LinkRow2(onClick: ()-> Unit, viewModel: SignInViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KusitmsLinkCheck(viewModel, onClick)
        IconButton(
            onClick = { viewModel.linkCountDown() },
        ) {
            Icon(
                painterResource(id = R.drawable.ic_trashcan),
                contentDescription = "Localized description",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}

