package com.kusitms.presentation.ui.home.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.home.profile.MyProfileViewModel
import com.kusitms.presentation.ui.profile.detail.ProfileDetailImage
import com.kusitms.presentation.ui.profile.detail.ProfileDetailInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun MyProfileScreen(
    viewModel: MyProfileViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val infoUser = viewModel.infoProfile
    val detailMemberInfo by viewModel.detailMemberInfo.collectAsStateWithLifecycle()

    Column {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_my_detail_topbar, "profile.name"),
            onBackClick = {
                onBack()
            }) {
            Text(
                text = stringResource(id = R.string.profile_detail_edit),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Main400,
                modifier = Modifier.clickable { /* 수정 */ }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900)
        ) {
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailImage(
                        name = infoUser.name,
                        profileImage = detailMemberInfo.profileImage,
                        period = infoUser.period.toString(),
                        part = detailMemberInfo.part,
                        description = detailMemberInfo.description,
                    )
                }
            }
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailInfo(
                        detailMemberInfo.major,
                        detailMemberInfo.interests,
                        infoUser.email,
                        infoUser.phoneNumber,
                        detailMemberInfo.links
                    )
                }
            }
        }
    }
}