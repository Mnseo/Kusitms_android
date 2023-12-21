package com.kusitms.presentation.ui.profile

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.ProfileContract
import com.kusitms.presentation.model.profile.ProfileContract.*
import com.kusitms.presentation.model.profile.ProfileViewModel
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Search
import kotlinx.coroutines.flow.collect

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()
    val context = LocalContext.current as Activity

    LaunchedEffect(key1 = viewModel.effect) {
        viewModel.effect.collect { effect ->
            when(effect) {
                is ProfileSideEffect.OpenPartToggle -> {
                    Toast.makeText(context, "클릭", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        KusitsmTopBarTextWithIcon(text = "프로필", iconContent = {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { },
                imageVector = KusitmsIcons.Search,
                contentDescription = "검색"
            )
        })
        KusitmsMarginVerticalSpacer(size = 32)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = KusitmsColorPalette.current.Grey700,
                contentColor = KusitmsColorPalette.current.Grey100
            )
        ) {
            Row(
                modifier = Modifier
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "파트 선택",
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Grey100,
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable {
                        print("zz")
                    }
                    .background(
                        color = KusitmsColorPalette.current.Grey700,
                        shape = RoundedCornerShape(16.dp)
                    ),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                            },
                        imageVector = KusitmsIcons.ArrowDown,
                        contentDescription = null,
                        tint = KusitmsColorPalette.current.Grey400,
                    )
                }
            }
        }
        ProfileListScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}