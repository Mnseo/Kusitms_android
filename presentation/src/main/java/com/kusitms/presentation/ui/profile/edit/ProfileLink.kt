package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.edit.ProfileEditViewModel
import com.kusitms.presentation.model.signIn.LinkType
import com.kusitms.presentation.ui.ImageVector.plusIcon
import com.kusitms.presentation.ui.signIn.KusitmsInputField
import com.kusitms.presentation.ui.signIn.component.LinkBottomSheet
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Composable
fun ProfileLink(viewModel: ProfileEditViewModel) {
    LinkColumn(viewModel)
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LinkColumn(viewModel: ProfileEditViewModel) {
    val linkItems by viewModel.linkItems.collectAsState()
    val maxLength = 4
    var isOpenLinkBottomSheet by remember { mutableStateOf(false) }
    var selectedLinkItemIndex by remember { mutableStateOf(-1) } // 선택된 링크 아이템의 인덱스

    if (isOpenLinkBottomSheet) {
        LinkBottomSheet(
            viewModel = viewModel,
            isOpenLinkBottomSheet,
            selectedLinkItemIndex
        ) { isOpen, selectedData ->
            isOpenLinkBottomSheet = isOpen
            if (!isOpen && selectedData is LinkType) {
                viewModel.updateLinkItem(
                    selectedLinkItemIndex,
                    selectedData,
                    linkItems[selectedLinkItemIndex].linkUrl
                )
            }
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
            Text(
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey300,
                text = stringResource(id = R.string.signin2_title2),
            )
            LinkRow1(viewModel, maxLength)
        }
        Spacer(modifier = Modifier.height(14.dp))
        LinkItemsDisplay(viewModel, onLinkTypeChange = { index ->
            selectedLinkItemIndex = index
            isOpenLinkBottomSheet = true
        })
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LinkRow1(viewModel: ProfileEditViewModel, maxLength: Int) {
    val linkItems by viewModel.linkItems.collectAsState()
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
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey300,
            text = "추가하기${linkItems.size}/${maxLength}",
            modifier = Modifier.clickable {
                if (linkItems.size < maxLength) {
                    viewModel.addLinkItem()
                }
            }
        )
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LinkItemsDisplay(viewModel: ProfileEditViewModel, onLinkTypeChange: (Int) -> Unit) {
    val linkItems by viewModel.linkItems.collectAsState()

    linkItems.forEachIndexed { index, _ ->
        LinkRow2(viewModel, index, onClick = { onLinkTypeChange(index) })
        KusitmsMarginVerticalSpacer(size = 8)
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LinkRow2(
    viewModel: ProfileEditViewModel,
    linkItemIndex: Int,
    onClick: () -> Unit,
) {
    val linkItems by viewModel.linkItems.collectAsState()
    val currentLinkItem = linkItems.getOrNull(linkItemIndex) ?: return
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KusitmsLinkCheck(
            viewModel,
            linkItemIndex,
            currentLinkItem.linkType,
            onClick
        )
        IconButton(
            onClick = { viewModel.removeLinkItem() },
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


@Composable
fun KusitmsLinkCheck(
    viewModel: ProfileEditViewModel,
    linkItemIndex: Int,
    currentLinkType: LinkType,
    onLinkTypeChange: () -> Unit,
) {
    Row(
        modifier = Modifier
            .width(300.dp)
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinkCheckBox(
            viewModel = viewModel,
            linkItemIndex = linkItemIndex,
            currentLinkType = currentLinkType,
            onClick = onLinkTypeChange
        )
        KusitmsMarginHorizontalSpacer(size = 5)
        LinkTextField(viewModel, linkItemIndex)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoroutinesApi::class)
@Composable
fun LinkTextField(viewModel: ProfileEditViewModel, linkItemIndex: Int) {
    val linkItems by viewModel.linkItems.collectAsState()
    val linkItem = linkItems[linkItemIndex]
    val textState = remember { mutableStateOf(linkItem.linkUrl) }
    val isClicked by remember { mutableStateOf(false) }
    val borderColor =
        if (isClicked) KusitmsColorPalette.current.Main500 else KusitmsColorPalette.current.Grey700
    Box(
        modifier = Modifier
            .width(220.dp)
            .height(48.dp)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(12.dp))
            .background(
                color = KusitmsColorPalette.current.Grey700,
                shape = RoundedCornerShape(12.dp)
            ),
    ) {
        KusitmsInputField(
            text = R.string.signin2_placeholder2,
            value = textState.value,
            onValueChange = {
                textState.value = it
                viewModel.updateLinkItem(linkItemIndex, linkItem.linkType, it)
            },
            modifier = Modifier
                .width(220.dp)
                .wrapContentHeight()
        )
    }
}


@Composable
fun LinkCheckBox(
    viewModel: ProfileEditViewModel,
    linkItemIndex: Int,
    currentLinkType: LinkType,
    onClick: () -> Unit,
) {
    var isOpenLinkBottomSheet by remember { mutableStateOf(false) }

    if (isOpenLinkBottomSheet) {
        LinkBottomSheet(
            viewModel,
            isOpenLinkBottomSheet,
            linkItemIndex
        ) { isSelected, selectedLinkType ->
            isOpenLinkBottomSheet = isSelected
            if (isSelected && selectedLinkType is LinkType) {
                viewModel.updateLinkItem(
                    linkItemIndex,
                    selectedLinkType,
                    viewModel.linkItems.value[linkItemIndex].linkUrl
                )
            }
        }
    }

    Row(
        modifier = Modifier
            .width(110.dp)
            .height(48.dp)
            .background(
                color = KusitmsColorPalette.current.Grey700,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val displayText = if (currentLinkType == LinkType.LINK) {
            stringResource(id = R.string.signin2_checkbox)
        } else {
            currentLinkType.displayName
        }

        Text(
            text = displayText,
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_under_errow),
                contentDescription = null,
                tint = KusitmsColorPalette.current.Grey400
            )
        }
    }
}


