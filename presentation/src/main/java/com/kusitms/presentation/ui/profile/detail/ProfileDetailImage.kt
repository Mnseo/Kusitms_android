package com.kusitms.presentation.ui.profile.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.icons.Icons
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.signIn.nameBox
import com.kusitms.presentation.ui.signIn.rocket

@Composable
fun ProfileDetailImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(463.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(size = 24.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_logo),
                contentDescription = null,
            )
            Box(
                modifier = Modifier
                    .width(182.dp)
                    .height(182.dp)
                    .background(
                        KusitmsColorPalette.current.Grey100,
                        shape = RoundedCornerShape(24.dp)
                    )
            ) { }
            Text(
                text = "이채연",
                style = KusitmsTypo.current.Header1,
                color = KusitmsColorPalette.current.White
            )
            Text(
                text = "27기 디자이너",
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400
            )
            Text(
                text = "코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트코멘트",
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey300,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 28.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileDetailImagePreview() {
    ProfileDetailImage()
}