package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.ImagePhoto
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.ImageVector.plusIcon
import com.kusitms.presentation.ui.ImageVector.trashCan

@Composable
fun SignInScreen2(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top)
    ) {
        TitleColumn()
        Spacer(modifier = Modifier.height(32.dp))
        PhotoColumn()
        Spacer(modifier = Modifier.height(16.dp))
        introColumn()
        Spacer(modifier = Modifier.height(4.dp))
        LinkColumn()
        Spacer(modifier = Modifier.weight(1f))
        ButtonRow("이전으로", "가입완료", navController)
    }
}

@Composable
fun PhotoColumn() {
    Box(
        modifier = Modifier
            .width(96.dp)
            .height(96.dp)
            .background(color = Color(0xFF20232D), shape = RoundedCornerShape(size = 12.dp))
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
fun TitleColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
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
            .background(KusitmsColorPalette.current.Black)
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
            .background(KusitmsColorPalette.current.Black)
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
            .background(KusitmsColorPalette.current.Black)
            .padding(start = 20.dp, top = 0.dp, end = 20.dp, bottom = 0.dp),
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
                color = KusitmsColorPalette.current.Black,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(start = 12.dp, top = 0.dp, end = 0.dp, bottom = 8.dp),
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
            .width(125.dp)
            .fillMaxHeight()
            .background(color = Color(0xFF0F1011), shape = RoundedCornerShape(size = 8.dp))
            .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.Top,
    ) {

        LinkInputField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkInputField() {
    var link by remember { mutableStateOf(TextFieldValue("https://www."))}
    TextField(
        value = link,
        onValueChange = {link = it},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = KusitmsColorPalette.current.Grey700,
            cursorColor = KusitmsColorPalette.current.Main500,
            focusedIndicatorColor = KusitmsColorPalette.current.Main500,
            unfocusedIndicatorColor = KusitmsColorPalette.current.Grey700
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        shape =  RoundedCornerShape(size = 12.dp),
        trailingIcon = {
            if (link.text.isNotEmpty()) {
                Icon(
                    imageVector = trashCan(),
                    contentDescription = null,
                    tint = KusitmsColorPalette.current.Grey500,
                    modifier = Modifier.clickable { link = TextFieldValue("")}
                )
            }
        }
    )
}




@Composable
fun ButtonRow(text1:String, text2:String, navController: NavController) {
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
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text1, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = { /* TODO: Handle button click */ },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main500),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = text2, style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}


@Preview
@Composable
fun example2() {
    SignInScreen2(navController = rememberNavController())
}