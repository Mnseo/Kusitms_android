package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsSnackField
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.login.member.TextColumn1
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.SignInFixedInput
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ProfileBasic(
    viewModel: ProfileEditViewModel = hiltViewModel(),
) {
    val email by viewModel.email.collectAsState()
    val phoneNum by viewModel.phoneNum.collectAsState()
    val name by viewModel.name.collectAsState()
    val major by viewModel.major.collectAsState()
    val selectedPart by viewModel.selectedPart.collectAsState()
    val interests by viewModel.interests.collectAsState()
    val likeCategoryText = if (interests.isNotEmpty()) {
        interests.joinToString(", ") { it.content }
    } else {
        stringResource(id = R.string.signin_member_hint1_3)
    }
    val emailError by viewModel.emailError.collectAsState()
    val phoneNumError by viewModel.phoneNumError.collectAsState()

    var isOpenPartBottomSheet by remember { mutableStateOf(false) }
    var isOpenLikeCategoryBottomSheet by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Grey900)
            .height(64.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top

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
    }
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(id = R.string.signin_member_title1),
        style = KusitmsTypo.current.SubTitle2_Semibold,
        color = KusitmsColorPalette.current.Grey300
    )
    Spacer(modifier = Modifier.height(28.dp))
    Text(
        text = stringResource(id = R.string.signin_member_caption1_1),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(5.dp))
    SignInFixedInput(modelValue = name)
    Spacer(modifier = Modifier.height(20.dp))

    //전공
    Text(
        text = stringResource(id = R.string.signin_member_caption1_2),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(5.dp))
    KusitmsInputField(
        text = R.string.signin_member_hint1_1,
        value = major,
        onValueChange = viewModel::updateMajor
    )
    if (major.length > 20) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "최대 20자까지 입력할 수 있어요",
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
    }

    Spacer(modifier = Modifier.height(24.dp))
    //파트 선택

    Text(
        text = stringResource(id = R.string.signin_member_caption1_3),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
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
    Text(
        text = stringResource(id = R.string.signin_member_caption1_4),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(5.dp))
    KusitmsSnackField(
        text = likeCategoryText,
        onSnackClick = {
            isOpenLikeCategoryBottomSheet = true
        }
    )


    Spacer(modifier = Modifier.height(40.dp))
    Text(
        text = stringResource(id = R.string.signin_member_title2),
        style = KusitmsTypo.current.SubTitle2_Semibold,
        color = KusitmsColorPalette.current.Grey300
    )
    //이메일
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = stringResource(id = R.string.signin_member_caption1_5),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(5.dp))
    KusitmsInputField(
        text = R.string.signin_member_hint1_4,
        value = email,
        onValueChange = viewModel::updateEmail
    )
    emailError?.let { error ->
        Text(
            text = error,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
    }

    //전화번호
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = stringResource(id = R.string.signin_member_caption1_6),
        style = KusitmsTypo.current.Caption1,
        color = KusitmsColorPalette.current.Grey400
    )
    Spacer(modifier = Modifier.height(5.dp))
    KusitmsInputField(
        text = R.string.signin_member_hint1_5,
        value = phoneNum,
        onValueChange = viewModel::updatePhoneNumber
    )
    phoneNumError?.let { error ->
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = error,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
    }
}