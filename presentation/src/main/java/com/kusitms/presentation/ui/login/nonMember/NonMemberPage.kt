package com.kusitms.presentation.ui.login.nonMember

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun NonMemberPage() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
        .background(color = KusitmsColorPalette.current.Main500, shape = RoundedCornerShape(16.dp))
    ) {
    Image(
        painter = painterResource(id = R.drawable.kusitms_non_member_1),
        contentDescription = null,
        contentScale = ContentScale.Crop, // 이미지가 Box를 채우도록 조정
        modifier = Modifier.matchParentSize() // 부모의 크기에 맞춤
    )
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            NonOfficialPageRow()
            Spacer(modifier = Modifier.height(40.dp))
            NonBottomPageRow()
        }

    }
}

@Composable
fun NonOfficialPageRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            painterResource(id = R.drawable.ic_nonmember_home),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            text= stringResource(id = R.string.nonMember_subtitle),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey100
        )
    }
}

@Composable
fun NonBottomPageRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    )
    {
        Text(
            text= stringResource(id = R.string.nonMember_body1),
            style = KusitmsTypo.current.Body1,
            color = KusitmsColorPalette.current.Main200,
            modifier = Modifier
                .width(168.dp)
                .height(48.dp)
        )

    }
}

@Preview
@Composable
fun PreviewPage() {
    NonMemberPage()
}