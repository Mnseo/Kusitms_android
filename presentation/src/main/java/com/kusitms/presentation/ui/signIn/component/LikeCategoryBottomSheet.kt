package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.KusitmsTabItem
import com.kusitms.presentation.common.ui.KusitmsTabRow
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.model.signIn.categories


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun LikeCatergoryBottomSheet(
    viewModel: SignInViewModel,
    openBottomSheet : Boolean = false,
    onChangeOpenBottomSheet : (Boolean) -> Unit = {}
){
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (openBottomSheet) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = {Box(Modifier.height(0.dp))},
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
                LikeBottomSheetContent(viewModel = viewModel)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .height(56.dp),
                    onClick = {
                        onChangeOpenBottomSheet(false) // 바텀 시트 닫기
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Grey500),
                    shape = RoundedCornerShape(size = 16.dp)
                ) {
                    Text(
                        text = "관심 카테고리를 선택해주세요",
                        style = KusitmsTypo.current.SubTitle2_Semibold,
                        color = KusitmsColorPalette.current.Grey400
                    )
                }
                KusitmsMarginVerticalSpacer(size = 24)
            }

        }
    }
}


@Composable
fun LikeCategoryTab(
    selectedCategories: List<String>,
    onCategorySelected: (String) -> Unit
) {
    KusitmsTabRow(
        tabItemList = categories,
        tabContent =  { category -> KusitmsTabItem(
            text = category.name,
            isSelected = selectedCategories.contains(category.name),
            onSelect = { onCategorySelected(category.name) }
        ) }
    )
    val currentCategory = categories.find { it.name in selectedCategories } ?: return
    when (currentCategory.name) {
            "기획" -> LikeCategoryItems(categories[0].subCategories)
            "개발" -> LikeCategoryItems(categories[1].subCategories)
            "디자인" -> LikeCategoryItems(categories[2].subCategories)
            "기타" -> LikeCategoryItems(categories[3].subCategories)
            else -> {
            }
        }
}


@Composable
fun LikeBottomSheetContent(viewModel: SignInViewModel) {
    val selectedCategories by viewModel.favoriteCategory.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 0.dp)
            .background(
                color = KusitmsColorPalette.current.Grey600,
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        KusitmsMarginVerticalSpacer(size = 24)
        CategoryBottomSheetTitle(viewModel = viewModel)
        KusitmsMarginVerticalSpacer(size = 16)
        LikeCategoryTab(
            selectedCategories = selectedCategories.orEmpty(),
            onCategorySelected = { category ->
                viewModel.updateFavoriteCategory(category)
            }
        )
    }

}

@Composable
fun CategoryBottomSheetTitle(viewModel: SignInViewModel) {
    val favoriteCategoryCount = viewModel.favoriteCategory.collectAsState().value?.size ?: 0
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(24.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "관심 카테고리", style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        KusitmsMarginHorizontalSpacer(size = 12)
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey500,
                    shape = RoundedCornerShape(size = 4.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = favoriteCategoryCount.toString(),
                style =  KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Main400)
        }
        KusitmsMarginHorizontalSpacer(size = 2)
        Text(
            text = "개 선택",
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_inputx),
                contentDescription = "bottomSheetDown",
                tint = KusitmsColorPalette.current.Grey300
            )
        }

    }
}


