package com.kusitms.presentation.ui.notice.search

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.domain.model.notice.NoticeModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.ImageVector.LeftArrow
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.Close
import com.kusitms.presentation.ui.notice.KusitmsNoticeItem
import com.kusitms.presentation.ui.notice.NoticeViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map

@OptIn(FlowPreview::class)
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun NoticeSearchScreen(
    viewModel : NoticeViewModel,
    onNoticeClick : (NoticeModel) -> Unit,
    onBackClick: () -> Unit
) {
    var searchKeyword by remember { mutableStateOf("") }

    val searchedNoticeList by viewModel.noticeList
        .map {
            it.filter {
                if(searchKeyword.isBlank()) false
                else {
                    it.title.contains(searchKeyword) ||
                    it.content.contains(searchKeyword) ||
                    it.curriculumName.contains(searchKeyword) ||
                    it.teamName.contains(searchKeyword)
                }
            }
        }
        .debounce(200)
        .collectAsStateWithLifecycle(
            emptyList()
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey800)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onBackClick()
                    },
                imageVector = LeftArrow.vector,
                contentDescription = "뒤로"
            )
            KusitmsMarginHorizontalSpacer(size = 12)
            SearchBar(
                searchKeyword = searchKeyword,
                onChangeKeyword = {
                    searchKeyword = it
                },
                onResetClick = {
                    searchKeyword = ""
                }
            )
        }
        if (searchedNoticeList.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text =  if(searchKeyword.isBlank()) stringResource(id = R.string.notice_search_default)
                            else stringResource(id = R.string.notice_search_empty,searchKeyword),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Grey400
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                item {
                    KusitmsMarginVerticalSpacer(size = 24)
                    Text(
                        text = stringResource(id = R.string.notice_search_count,searchedNoticeList.size),
                        style = KusitmsTypo.current.Caption1,
                        color = KusitmsColorPalette.current.Grey400
                    )
                    KusitmsMarginVerticalSpacer(size = 12)
                }
                items(searchedNoticeList){
                    KusitmsNoticeItem(
                        notice = it,
                        onClick = {
                            onNoticeClick(it)
                        },
                        useAlpha = false
                    )
                }
            }
        }
    }

}

@Composable
fun RowScope.SearchBar(
    searchKeyword: String,
    onChangeKeyword: (String) -> Unit,
    onResetClick: () -> Unit
) {
    BasicTextField(
        modifier = Modifier
            .wrapContentHeight()
            .weight(1f),
        value = searchKeyword,
        maxLines = 1,
        textStyle = KusitmsTypo.current.Text_Medium.copy(color = KusitmsColorPalette.current.Grey100),
        onValueChange = {
            onChangeKeyword(it)
        },
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(KusitmsColorPalette.current.Grey600, RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if(searchKeyword.isBlank())
                        Text(
                            text = stringResource(id = R.string.notice_search_hint),
                            style = KusitmsTypo.current.Text_Medium,
                            color =  KusitmsColorPalette.current.Grey400
                        )
                    innerTextField()
                }
                KusitmsMarginHorizontalSpacer(size = 10)
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            onResetClick()
                        },
                    imageVector = KusitmsIcons.Close,
                    contentDescription = "초기화"
                )
            }

        }
    )
}