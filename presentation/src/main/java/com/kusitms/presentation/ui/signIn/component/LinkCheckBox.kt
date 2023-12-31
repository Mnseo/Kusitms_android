package com.kusitms.presentation.ui.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.ui.signIn.component.LinkBottomSheet

@Composable
fun LinkCheckBox(viewModel: SignInViewModel, onClick: () -> Unit) {
    var isOpenLinkBottomSheet by remember { mutableStateOf(false)}

    if (isOpenLinkBottomSheet) {
        LinkBottomSheet(viewModel) {
            isOpenLinkBottomSheet = it
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
        Text(text = stringResource(id = R.string.signin2_checkbox), style = KusitmsTypo.current.Text_Medium, color = KusitmsColorPalette.current.Grey400)
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

