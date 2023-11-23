package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
    Box(
        modifier = Modifier
            .width(154.dp)
            .height(44.dp)
            .padding(horizontal = 12.dp)
            .border(width = 1.dp, color = KusitmsColorPalette.current.Grey500, shape= RoundedCornerShape(12.dp))
            .background(color = KusitmsColorPalette.current.Grey600),
    ) {
        Text(
            text = subCategoryName,
            style =  KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey300
        )
    }
}

@Composable
fun LikeCategoryItems(subCategories: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(436.dp)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
    ) {
        items(subCategories) { subCategory ->
            LikeCategoryItem(subCategoryName = subCategory)
        }
    }
}

@Preview
@Composable
fun ColumnItem() {

}

