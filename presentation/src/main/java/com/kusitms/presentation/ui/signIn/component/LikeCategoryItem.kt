package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.color.utilities.DislikeAnalyzer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.PartCategory
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.model.signIn.categories
import com.kusitms.presentation.model.signIn.getAllSubCategories

@Composable
fun LikeCategoryItem(subCategoryName:String) {
    var isSelected by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .height(44.dp)
            .padding(horizontal = 12.dp)
            .border(
                width = 1.dp,
                color = KusitmsColorPalette.current.Grey500,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                isSelected = !isSelected // Toggle the selection state
            }
            .background(
                color = if (isSelected) KusitmsColorPalette.current.Grey500 else KusitmsColorPalette.current.Grey600,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = subCategoryName,
            style =  KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey300,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun LikeCategoryItems(subCategories: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2개의 컬럼을 가진 그리드
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .height(436.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(subCategories) { subCategory ->
            LikeCategoryItem(subCategoryName = subCategory)
        }
    }
}


