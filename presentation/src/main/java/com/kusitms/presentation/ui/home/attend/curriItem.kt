package com.kusitms.presentation.ui.home.attend

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.home.attend.AttendViewModel


@Composable
fun CurriItem(
    status: AttendViewModel.Status
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(78.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {


    }
}

@Composable
fun CurriTitleRow(
    title: String,
    date: String,
    status: AttendViewModel.Status
) {
    val statusColor = when(status) {
        AttendViewModel.Status.PRESENT -> KusitmsColorPalette.current.Sub1
        AttendViewModel.Status.ABSENT, AttendViewModel.Status.LATE -> KusitmsColorPalette.current.Sub2
        else -> ""
    }

    Row(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        status.toDrawable()
        Column(
            modifier = Modifier.
        ) {

        }
    }

}