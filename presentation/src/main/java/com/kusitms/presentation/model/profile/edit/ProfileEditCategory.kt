package com.kusitms.presentation.model.profile.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitmsTabItem
import com.kusitms.presentation.common.ui.KusitmsTabRow
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.signIn.InterestItem
import com.kusitms.presentation.model.signIn.PartCategory
import com.kusitms.presentation.model.signIn.mapCategoryToValue
import com.kusitms.presentation.ui.profile.edit.LikeBottomSheetContent
import com.kusitms.presentation.ui.profile.edit.PartSelectItem
import com.kusitms.presentation.ui.signIn.component.LikeCategoryItem
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Composable
fun PartSelectColumn(viewModel: ProfileEditViewModel) {
    val filteredCategories = com.kusitms.presentation.model.signIn.categories.filter { it.name != "기타" }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {
        items(filteredCategories) { category ->
            PartSelectItem(
                category = category,
                onClick = { selectedCategory ->
                    val selectedValue = mapCategoryToValue(selectedCategory.name)
                    viewModel.updateSelectedPart(selectedValue)
                },
                viewModel = viewModel
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun LikeCategoryBottomSheet(
    viewModel: ProfileEditViewModel,
    openBottomSheet: Boolean = false,
    onChangeOpenBottomSheet: (Boolean) -> Unit = {},
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (openBottomSheet) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = { Box(Modifier.height(0.dp)) },
            onDismissRequest = { onChangeOpenBottomSheet(false) },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .height(704.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .systemBarsPadding()
                    .statusBarsPadding()
            ) {
                LikeBottomSheetContent(
                    viewModel = viewModel,
                    onClick = { onChangeOpenBottomSheet(false) })
            }

        }
    }
}




@Composable
fun LikeCategoryTab(selectedCategory: PartCategory, onCategorySelected: (PartCategory) -> Unit, viewModel: ProfileEditViewModel) {
    KusitmsTabRow(
        tabItemList = com.kusitms.presentation.model.signIn.categories,
        tabContent = { category ->
            KusitmsTabItem(
                text = category.name,
                isSelected = category == selectedCategory,
                onSelect = { onCategorySelected(category) }
            )
        }
    )
    when (selectedCategory.name) {
        "기획" -> LikeCategoryItems(category = com.kusitms.presentation.model.signIn.categories[0], viewModel = viewModel)
        "개발" -> LikeCategoryItems(category = com.kusitms.presentation.model.signIn.categories[1], viewModel = viewModel)
        "디자인" -> LikeCategoryItems(category = com.kusitms.presentation.model.signIn.categories[2], viewModel = viewModel)
        "기타" -> LikeCategoryItems(category = com.kusitms.presentation.model.signIn.categories[3], viewModel = viewModel)
        else -> {}
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LikeCategoryItems(category: PartCategory, viewModel: ProfileEditViewModel) {
    val selectedInterests = viewModel.interests.collectAsState().value.toMutableSet()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
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