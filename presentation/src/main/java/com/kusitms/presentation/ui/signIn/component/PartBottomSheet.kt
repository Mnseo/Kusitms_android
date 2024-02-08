package com.kusitms.presentation.ui.signIn

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.signIn.SignInViewModel
import com.kusitms.presentation.model.signIn.categories
import com.kusitms.presentation.model.signIn.mapCategoryToValue
import com.kusitms.presentation.ui.ImageVector.xIcon


@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterialApi
@Composable
fun PartBottomSheet(
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
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .systemBarsPadding()
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                PartSnackTitle( onClick = { onChangeOpenBottomSheet(false) } )
                KusitmsMarginVerticalSpacer(size = 20)
                partSelectColumn(viewModel = viewModel)
            }
        }
    }
}



@Composable
fun partSelectColumn(viewModel: SignInViewModel) {
    val filteredCategories = categories.filter { it.name != "기타" }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {
        items(filteredCategories) { category ->
            partSelectItem(category = category,
                onClick = { selectedCategory ->
                    val selectedValue = mapCategoryToValue(selectedCategory.name)
                    viewModel.updateSelectedPart(selectedValue)
                    Log.d("Part", viewModel.selectedPart.value.toString()) },
                viewModel = viewModel)
        }
    }
}

@Composable
fun PartSnackTitle(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 36.dp)
            .height(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.part_snack_title), style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300)
        xIcon.drawxIcon(modifier = Modifier.clickable { onClick() })

    }
}



