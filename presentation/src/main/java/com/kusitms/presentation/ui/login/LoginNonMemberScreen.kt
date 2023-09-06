package com.kusitms.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KustimsTypo


@Composable
fun LoginNonMember(navController: NavController) {
    val img = com.kusitms.presentation.R.drawable.kusitms_non_member_1
    val painter = painterResource(id = img)
    ImageCard(painter = painter , contentDescription = "Kustims Banner", title = "Kustims Banner")

}




@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),

    ) {
        Box(modifier =
        Modifier
            .width(154.24.dp)
            .height(154.24.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.FillBounds
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = KusitmsColorPalette.current.Main500)
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart){
                Text(title,style= KustimsTypo.current.Body1, color = KusitmsColorPalette.current.Main200)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun snsSite() {
    LoginNonMember(navController = rememberNavController())

}