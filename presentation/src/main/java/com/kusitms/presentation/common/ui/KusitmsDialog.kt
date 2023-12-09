package com.kusitms.presentation.common.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun KusitmsDialog(
    title : String,
    content: @Composable () -> Unit,
    okText : String = "확인",
    cancelText : String = "취소하기",
    okColor : Color = KusitmsColorPalette.current.Grey200,
    cancelColor : Color = KusitmsColorPalette.current.Grey200,
    onOk : () -> Unit,
    onCancel : () -> Unit,
    onDismiss : () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey600,
                contentColor = KusitmsColorPalette.current.Grey300
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = KusitmsTypo.current.SubTitle2_Semibold,
                    color =  KusitmsColorPalette.current.White
                )
                KusitmsMarginVerticalSpacer(size = 8)
                content()
                KusitmsMarginVerticalSpacer(size = 24)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ){
                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        onClick = onCancel,
                        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600),
                        border = BorderStroke(1.dp, cancelColor),
                        shape = RoundedCornerShape(size = 12.dp)
                    ) {
                        Text(text = cancelText, style = KusitmsTypo.current.Text_Semibold, color = cancelColor)
                    }

                    OutlinedButton(
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        onClick = onOk,
                        colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey600),
                        border = BorderStroke(1.dp, okColor),
                        shape = RoundedCornerShape(size = 12.dp)
                    ) {
                        Text(text = okText, style = KusitmsTypo.current.Text_Semibold, color = okColor)
                    }
                }
            }
        }
    }
}