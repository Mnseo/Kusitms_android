package com.kusitms.presentation.ui.login.nonMember

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R

@Composable
fun NonMemberLogo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp),
        horizontalArrangement = Arrangement.spacedBy(5.74.dp),
        verticalAlignment = Alignment.CenterVertically
        )
     {
        Icon(
            painterResource(id = R.drawable.ic_nonmember_kusitms_logo),
            tint = Color.Unspecified,
            contentDescription = null
        )
         Icon(
             painterResource(id = R.drawable.ic_nonmember_kusitms_plus),
             tint = Color.Unspecified,
             contentDescription = null
         )
    }
}