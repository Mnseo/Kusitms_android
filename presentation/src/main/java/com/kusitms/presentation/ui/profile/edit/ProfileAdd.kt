package com.kusitms.presentation.ui.profile.edit

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.ui.ImageVector.ImagePhoto
import com.kusitms.presentation.ui.ImageVector.StudyIcon
import com.kusitms.presentation.ui.signIn.TextColumn
import com.kusitms.presentation.ui.signIn.Title2Column
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ProfileAdd(
    viewModel: ProfileEditViewModel = hiltViewModel(),
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
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            StudyIcon.drawStudyIcon(
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .background(KusitmsColorPalette.current.Grey900),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top

            ) {
                Text(
                    text = stringResource(id = R.string.signin2_text1),
                    style = KusitmsTypo.current.SubTitle2_Semibold,
                    color = KusitmsColorPalette.current.Grey300
                )
                Text(
                    text = stringResource(id = R.string.signin2_text2),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Sub1
                )
            }
        }
        PhotoColumn(viewModel)
        KusitmsMarginVerticalSpacer(size = 10)
        IntroEditColumn(viewModel)
        KusitmsMarginVerticalSpacer(size = 4)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun PhotoColumn(viewModel: ProfileEditViewModel) {
    val imageUri by viewModel.selectedImage.collectAsState() // This should be a Uri? in your ViewModel

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                viewModel.updateSelectedImage(uri)
            }
        }

    Box(
        modifier = Modifier
            .width(96.dp)
            .height(96.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(size = 12.dp)
            )
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
fun IntroEditColumn(viewModel: ProfileEditViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(KusitmsColorPalette.current.Grey900),
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = R.string.signin2_title1),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        IntroEditTextField(viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoroutinesApi::class)
@Composable
fun IntroEditTextField(viewModel: ProfileEditViewModel) {
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
                    if (it.length <= maxLength) {
                        viewModel.updateIntroduce(it)
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = KusitmsColorPalette.current.Grey600,
                    unfocusedContainerColor = KusitmsColorPalette.current.Grey600,
                    disabledContainerColor = KusitmsColorPalette.current.Grey600,
                    cursorColor = KusitmsColorPalette.current.Grey400,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = KusitmsColorPalette.current.White,
                    unfocusedTextColor = KusitmsColorPalette.current.White,
                    disabledLabelColor = KusitmsColorPalette.current.White,
                ),
                placeholder = {
                    Text(
                        stringResource(id = R.string.signin2_placeholder1),
                        style = KusitmsTypo.current.Text_Medium,
                        color = KusitmsColorPalette.current.Grey400
                    )
                }
            )
        }
        Text(
            text = "${textState.length}/$maxLength",
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
    }
}


