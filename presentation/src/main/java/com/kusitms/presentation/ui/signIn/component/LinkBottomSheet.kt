package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.model.signIn.linkCategories
import com.kusitms.presentation.ui.ImageVector.xIcon


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkBottomSheet(
    viewModel: ViewModel,
    openBottomSheet: Boolean = false,
    linkItemIndex: Int,
    onChangeOpenBottomSheet: (Boolean, Any?) -> Unit = { b: Boolean, any: Any? -> }
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if(openBottomSheet) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = {Box(Modifier.height(0.dp))},
            onDismissRequest = { onChangeOpenBottomSheet(false, null) },
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
                LinkBottomSheetTitle(onClick = {onChangeOpenBottomSheet(false, null)})
                KusitmsMarginVerticalSpacer(size = 20)
                LinkSelectColumn(viewModel, linkItemIndex)
            }

        }
    }

}

@Composable
fun LinkSelectColumn(viewModel: ViewModel, linkItemIndex: Int) {
    LazyColumn(modifier = Modifier.padding(horizontal = 12.dp)) {
        items(linkCategories) { category ->
            LinkItem(
                category = category,
                onClick = {
                    if (viewModel is SignInViewModel) {
                        viewModel.updateLinkTypeAt(linkItemIndex, category.linkType)
                    } else if (viewModel is ProfileEditViewModel) {
                        viewModel.updateLinkTypeAt(linkItemIndex, category.linkType)
                    }
                }
            )
        }
    }
}

@Composable
fun LinkBottomSheetTitle(onClick: ()-> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .height(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.signin2_title3), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        xIcon.drawxIcon(modifier = Modifier.clickable { onClick() })
    }
}

