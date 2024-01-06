package com.kusitms.presentation.ui.login.member

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.domain.usecase.signin.CreateMoimTitle
import com.kusitms.domain.usecase.signin.MoimCreateBtn
import com.kusitms.domain.usecase.signin.TeumDivider
import com.kusitms.presentation.common.ui.theme.TmtmColorPalette

@Composable
fun MoimIntroduce() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .background(color = TmtmColorPalette.current.GreyWhite),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        CreateMoimTitle(string="모임을 소개해 주세요")
        TeumDivider()
        MoimCreateBtn(text = "다음")
        Spacer(modifier = Modifier.height(24.dp))

    }
}

@Composable
fun MoimIntroField() {

}

@Composable
fun MoimPhotoInput() {

}