package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.LinkType
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.ui.signIn.component.LinkBottomSheet

@Composable
fun LinkCheckBox(viewModel: SignInViewModel, linkItemIndex: Int, currentLinkType: LinkType, onClick: () -> Unit) {
    var isOpenLinkBottomSheet by remember { mutableStateOf(false)}

    if (isOpenLinkBottomSheet) {
        LinkBottomSheet(viewModel, isOpenLinkBottomSheet,linkItemIndex) { isSelected, selectedLinkType ->
            isOpenLinkBottomSheet = isSelected
            if (isSelected && selectedLinkType is LinkType) {
                viewModel.updateLinkItem(linkItemIndex, selectedLinkType, viewModel.linkItems.value[linkItemIndex].linkUrl)
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

        Text(text = displayText, style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        IconButton(
            modifier= Modifier.size(24.dp),
            onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_under_errow),
                contentDescription = null,
                tint = KusitmsColorPalette.current.Grey400
            )
        }}

    }

