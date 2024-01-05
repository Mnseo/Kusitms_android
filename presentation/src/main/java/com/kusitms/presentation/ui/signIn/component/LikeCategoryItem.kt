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
import com.kusitms.presentation.model.signIn.*

@Composable
fun LikeCategoryItem(subCategoryName:String, isSelected: Boolean, onSelect: () -> Unit) {
    Box(
        modifier = Modifier
            .height(44.dp)
            .border(
                width = 1.dp,
                color = KusitmsColorPalette.current.Grey500,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onSelect)
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
fun LikeCategoryItems(category: PartCategory, viewModel: SignInViewModel) {
    val selectedInterests = viewModel.interests.collectAsState().value.toMutableSet()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2개의 컬럼을 가진 그리드
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .height(436.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(category.subCategories) { subCategory ->
            val interestItem = InterestItem(mapCategoryToValue(category.name), subCategory)
            LikeCategoryItem(
                subCategoryName = subCategory,
                isSelected = interestItem in selectedInterests,
                onSelect = {
                    if (interestItem in selectedInterests) {
                        selectedInterests.remove(interestItem)
                    } else {
                        selectedInterests.add(interestItem)
                    }
                    viewModel.updateInterests(selectedInterests.toList())
                }
            )
        }
    }
}


