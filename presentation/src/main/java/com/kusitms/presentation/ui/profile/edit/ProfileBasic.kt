package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitmsSnackField
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.LikeCategoryBottomSheet
import com.kusitms.presentation.model.profile.edit.LikeCategoryTab
import com.kusitms.presentation.model.profile.edit.PartSelectColumn
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.model.signIn.PartCategory
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.login.member.TextColumn1
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.PartSnackTitle
import com.kusitms.presentation.ui.signIn.SignInFixedInput
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoroutinesApi::class)
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

    if (isOpenPartBottomSheet) {
        PartBottomSheet(
            viewModel = viewModel,
            isOpenPartBottomSheet
        ) {
            isOpenPartBottomSheet = it
            if (!selectedPart.isNullOrBlank()) {
                isOpenPartBottomSheet = false
            }
        }
    }

    if (isOpenLikeCategoryBottomSheet) {
        LikeCategoryBottomSheet(
            viewModel = viewModel,
            isOpenLikeCategoryBottomSheet
        )
        {
            isOpenLikeCategoryBottomSheet = it
        }
    }

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


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun PartBottomSheet(
    viewModel: ProfileEditViewModel,
    openBottomSheet: Boolean = false,
    onChangeOpenBottomSheet: (Boolean) -> Unit = {},
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (openBottomSheet) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = { Box(Modifier.height(0.dp)) },
            onDismissRequest = { onChangeOpenBottomSheet(false) },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .systemBarsPadding()
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                PartSnackTitle(onClick = { onChangeOpenBottomSheet(false) })
                KusitmsMarginVerticalSpacer(size = 20)
                PartSelectColumn(viewModel = viewModel)
            }
        }
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun PartSelectItem(
    category: PartCategory,
    onClick: (PartCategory) -> Unit,
    viewModel: ProfileEditViewModel,
) {
    val isSelected = viewModel.selectedPart.collectAsState().value?.contains(category.name) == true
    val background = if (isSelected) KusitmsColorPalette.current.Grey500 else Color.Transparent
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = background, shape = RoundedCornerShape(size = 12.dp))
            .clickable { onClick(category) }
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        category.icon?.let { iconRes ->
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Text(
            text = category.name,
            style = KusitmsTypo.current.Text_Medium,
            color = KusitmsColorPalette.current.Grey100
        )
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LikeBottomSheetContent(viewModel: ProfileEditViewModel, onClick: () -> Unit) {
    var selectedCategory by remember { mutableStateOf(com.kusitms.presentation.model.signIn.categories.first()) }
    val favoriteCategoryCount by viewModel.interests.collectAsState()
    val buttonText = if (favoriteCategoryCount.isNotEmpty()) "확인" else "관심 카테고리를 선택해주세요"
    val buttonColor =
        if (favoriteCategoryCount.isNotEmpty()) KusitmsColorPalette.current.Grey100 else KusitmsColorPalette.current.Grey500
    val buttonTextColor =
        if (favoriteCategoryCount.isNotEmpty()) KusitmsColorPalette.current.Grey600 else KusitmsColorPalette.current.Grey400

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        KusitmsMarginVerticalSpacer(size = 24)
        CategoryBottomSheetTitle(
            viewModel = viewModel,
            onClick
        )
        KusitmsMarginVerticalSpacer(size = 16)
        LikeCategoryTab(
            selectedCategory = selectedCategory,
            onCategorySelected = { category -> selectedCategory = category },
            viewModel = viewModel
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(56.dp),
            onClick = {
                onClick()
            },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Text(
                text = buttonText,
                style = KusitmsTypo.current.SubTitle2_Semibold,
                color = buttonTextColor
            )
        }
        KusitmsMarginVerticalSpacer(size = 24)
    }

}


@Composable
fun CategoryBottomSheetTitle(
    viewModel: ProfileEditViewModel,
    onClick: () -> Unit,
) {
    val favoriteCategoryCount = viewModel.interests.value.size ?: 0
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(24.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "관심 카테고리",
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        KusitmsMarginHorizontalSpacer(size = 12)
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey500,
                    shape = RoundedCornerShape(size = 4.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = favoriteCategoryCount.toString(),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Main400
            )
        }
        KusitmsMarginHorizontalSpacer(size = 2)
        Text(
            text = "개 선택",
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {
            onClick()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_inputx),
                contentDescription = "bottomSheetDown",
                tint = KusitmsColorPalette.current.Grey300
            )
        }

    }
}