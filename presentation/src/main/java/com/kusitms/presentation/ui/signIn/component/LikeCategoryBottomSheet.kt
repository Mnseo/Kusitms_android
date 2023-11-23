package com.kusitms.presentation.ui.signIn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.kusitms.presentation.model.signIn.PartCategory
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.model.signIn.categories
import com.kusitms.presentation.ui.ImageVector.xIcon
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun SheetLayout(viewModel: SignInViewModel){
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )
    Button(onClick = {
        scope.launch {
            openBottomSheet = !openBottomSheet
        }
    }) {
        Text(text = "Show Bottom Sheet")
    }

    if (openBottomSheet) {
        ModalBottomSheet(
            containerColor = KusitmsColorPalette.current.Grey600,
            dragHandle = {Box(Modifier.height(0.dp))},
            onDismissRequest = { openBottomSheet = false },
            sheetState = bottomSheetState,
            modifier = Modifier
                .fillMaxWidth()
                .height(653.dp)
        ) {
            LikeBottomSheetContent(viewModel = viewModel)
        }
    }
}


@Composable
fun LikeCategoryTab(selectedCategory: PartCategory, onCategorySelected: (PartCategory) -> Unit) {
    KusitmsTabRow(
        tabItemList = categories,
        tabContent =  { category -> KusitmsTabItem(
            text = category.name,
            isSelected = category == selectedCategory,
            onSelect =  {onCategorySelected(category) }
        ) }
    )
        when(selectedCategory.name) {
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
    var selectedCategory by remember { mutableStateOf(categories.first()) }
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
        LikeCategoryTab(selectedCategory = selectedCategory, onCategorySelected = { category->
            selectedCategory = category
        })
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
        Text(text = "개 선택", style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
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


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun BottomSheetPre1() {
    SheetLayout(viewModel = SignInViewModel())
}

