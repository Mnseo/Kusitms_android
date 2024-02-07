package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitmsSnackField
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.model.profile.edit.ProfileFilterList
import com.kusitms.presentation.model.profile.edit.categories
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.login.member.TextColumn1
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.SignInFixedInput
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ProfileEditScreen(
    viewModel: ProfileEditViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val scrollState = rememberScrollState()

    val expanded by viewModel.expended.collectAsStateWithLifecycle()
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


    Column {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_edit_toolbar),
            onBackClick = {
                onBack()
            },
        ) {
            Text(
                text = stringResource(id = R.string.profile_edit_modify),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Main400,
                modifier = Modifier.clickable {

                }
            )
        }
        KusitmsMarginVerticalSpacer(size = 32)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable {
                    viewModel.toggleExpanded()
                },
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey700,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            ProfileFilterButton(
                expanded = expanded,
                viewModel = viewModel
            )
            if (expanded) {
                AllProfileFilterList(
                    partNameList = categories,
                    viewModel = viewModel
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(KusitmsColorPalette.current.Grey900)
                .verticalScroll(scrollState)
                .height(910.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
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
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
private fun ProfileFilterButton(
    expanded: Boolean,
    viewModel: ProfileEditViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()


    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = uiState.currentSelectedProfileFilter.takeIf { it.isNotEmpty() }
                ?: stringResource(id = R.string.profile_edit_basic),
            style = KusitmsTypo.current.Text_Medium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            color = KusitmsColorPalette.current.Grey100,
        )
        Icon(
            imageVector = KusitmsIcons.ArrowDown,
            contentDescription = stringResource(id = R.string.profile_edit_filter),
            tint = KusitmsColorPalette.current.Grey400,
            modifier = Modifier
                .rotate(if (expanded) 180f else 0f)
                .padding(horizontal = 16.dp)
        )
    }
}


@Composable
fun AllProfileFilterList(
    partNameList: List<ProfileFilterList>,
    viewModel: ProfileEditViewModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        partNameList.forEach { profile ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .clickable {
                        viewModel.changeSelectProfileFilter(profile.name)

                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = profile.name,
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Grey400,
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen(
        onBack = {}
    )
}
