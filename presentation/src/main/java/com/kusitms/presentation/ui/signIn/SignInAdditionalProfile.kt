package com.kusitms.presentation.ui.signIn

import android.content.Context
import android.net.Uri
import android.util.Base64
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.ButtonRow
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.navigation.NavRoutes
import com.kusitms.presentation.ui.ImageVector.*
import java.io.ByteArrayOutputStream


@Composable
fun SignInAdditionalProfile(viewModel: SignInViewModel,navController: NavHostController) {
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
        introColumn()
        KusitmsMarginVerticalSpacer(size = 4)
        LinkColumn()
        Spacer(modifier = Modifier.weight(1f))
        ButtonRow("이전으로", "가입완료", navController, KusitmsColorPalette.current.Grey600,KusitmsColorPalette.current.Main500,
            onNextClick = { navController.navigate(NavRoutes.SignInProfileComplete.route)})
        KusitmsMarginVerticalSpacer(size = 24)
    }
}

@Composable
fun PhotoColumn(viewModel: SignInViewModel) {
    val context = LocalContext.current
    val imagePickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // 이미지 처리 및 ViewModel 업데이트 로직
        uri?.let {
            val imageString = convertUriToString(uri, context)
            viewModel.updateSelectedImage(imageString)
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
            ImagePhoto()
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
fun introColumn() {
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
        introTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun introTextField() {
    val maxLength = 100
    val textState = remember { mutableStateOf(TextFieldValue()) }
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
                value = textState.value,
                onValueChange = {
                    if(it.text.length <= maxLength) { textState.value = it }
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
        Text(text = "${textState.value.text.length}/$maxLength", style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
    }
}

@Composable
fun LinkColumn() {
    val currentLength = remember { mutableStateOf(1) }
    val maxLength = 4
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
            LinkRow1(currentLength, maxLength)
        }
        Spacer(modifier = Modifier .height(14.dp))
        repeat(currentLength.value) {
            LinkRow2()
        }
    }

}

@Composable
fun LinkRow1(currentLength: MutableState<Int>, maxLength: Int) {
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
            text = "추가하기${currentLength.value}/${maxLength}",
            modifier = Modifier.clickable {
                if (currentLength.value < maxLength) { // 4개 이상 추가되지 않도록 제한
                    currentLength.value += 1
                }
            }
        )
    }
}

@Composable
fun LinkRow2() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KusitmsLinkCheck()
        IconButton(
            onClick = {  },
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

fun convertUriToString(uri: Uri, context: Context): String {
    val inputStream = context.contentResolver.openInputStream(uri)
    val byteArrayOutputStream = ByteArrayOutputStream()

    val buffer = ByteArray(1024)
    var bytesRead: Int
    while (inputStream?.read(buffer).also { bytesRead = it ?: -1 } != -1) {
        byteArrayOutputStream.write(buffer, 0, bytesRead)
    }

    val imageBytes = byteArrayOutputStream.toByteArray()

    return Base64.encodeToString(imageBytes, Base64.DEFAULT)
}
