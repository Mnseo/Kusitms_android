package com.kusitms.presentation.ui.home.attend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.common.ui.KusitmsMarginVerticalSpacer
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitmsMarginHorizontalSpacer
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.home.attend.AttendViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Year
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AttendScreen(
    viewModel: AttendViewModel,
    navController: NavHostController
) {

    LaunchedEffect(Unit){
        viewModel.getAttendList()
        viewModel.getUpcomingAttend()
        viewModel.getAttendScore()
    }

    val attendCurrentList by viewModel.attendListInit.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = KusitmsColorPalette.current.Grey800),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(color = KusitmsColorPalette.current.Grey900),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            AttendTopBar()
            KusitmsMarginVerticalSpacer(size = 8)
            AttendPreColumn(viewModel,navController)
            KusitmsMarginVerticalSpacer(size = 24)
            AttendRecordColumn(viewModel)
            KusitmsMarginVerticalSpacer(size = 32)
        }
        if (attendCurrentList.isNotEmpty()) {
            KusitmsMarginVerticalSpacer(size = 30)
            attendCurrentList.forEach { model ->
                CurriItem(model = model)
            }
        } else {
            AttendNotAttend()
        }
        Spacer(modifier = Modifier
            .weight(1f)
            .background(color = KusitmsColorPalette.current.Grey800))
    }
    ScrollBtn(scrollState = scrollState)
}

@Composable
fun AttendTopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "출석",
            style = KusitmsTypo.current.SubTitle1_Semibold,
            color = KusitmsColorPalette.current.Grey100
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AttendPreColumn(
    viewModel: AttendViewModel,
    navController: NavHostController
) {
    val curri by viewModel.upcomingAttend.collectAsState()
    val curriculum = curri.curriculumName
    val timeUntilEvent by viewModel.timeUntilEvent.collectAsState()


    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)
        .height(108.dp)
        .background(color = KusitmsColorPalette.current.Grey800, shape = RoundedCornerShape(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .width(188.dp)
                    .height(56.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.attend_box1_title),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Main500
                )
                KusitmsMarginVerticalSpacer(size = 4)
                Text(
                    text = curriculum,
                    style = KusitmsTypo.current.SubTitle1_Semibold,
                    color = KusitmsColorPalette.current.White
                )
            }
            when {
                timeUntilEvent.startsWith("D-") -> {
                    AttendBtnOff(timeUntilEvent)
                }
                timeUntilEvent.matches(Regex("\\d{2}:\\d{2}")) -> {
                    AttendBtnOff(timeUntilEvent) // HH:MM 형식으로 남은 시간이 표시될 때
                }
                timeUntilEvent == "Soon" -> {
                    AttendBtnOn(navController)
                }
                timeUntilEvent == "Ended" -> {
                    if(curri.isAttended) {
                        AttendBtnSuccess()
                    } else {
                        AttendBtnFailure()
                    }
                }
            }
        }
    }
}

@Composable
fun AttendRecordColumn(
    viewModel: AttendViewModel
) {
    val attendModel by viewModel.attendScore.collectAsState()
    val penalty = attendModel.penalty
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(266.dp)
        .padding(horizontal = 20.dp)
        .background(color = KusitmsColorPalette.current.Grey800, shape = RoundedCornerShape(24.dp))){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.attend_box2_title), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
                Box(modifier = Modifier
                    .width(123.dp)
                    .height(36.dp)
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(8.dp)
                    )
                ){
                    Text(text = stringResource(R.string.attend_btn2_attend), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400, modifier = Modifier.align(Alignment.Center))
                }
            }
            KusitmsMarginVerticalSpacer(size = 24)
            Text(text = "벌점 ${penalty}점", style = KusitmsTypo.current.Header2, color = KusitmsColorPalette.current.Grey100)
            KusitmsMarginVerticalSpacer(size = 14)
            AttendCanComplete(viewModel)
            KusitmsMarginVerticalSpacer(size = 24)
            AttendBoxRow(viewModel)
        }
    }
}

@Composable
fun AttendCanComplete(
    viewModel: AttendViewModel
) {
    val attendModel by viewModel.attendScore.collectAsState()
    val penalty = attendModel.penalty
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        if(penalty >= 6) {
            AttendNotComplete()
        } else {
            Text(text = stringResource(R.string.attend_box3_subTitle_ok), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub1)
            KusitmsMarginHorizontalSpacer(size = 6)
            Icon(painter = painterResource(id = R.drawable.ic_thumb), contentDescription = null, tint = Color.Unspecified)
        }
    }
}

@Composable
fun AttendNotComplete() {
    Text(text = stringResource(R.string.attend_box3_subTitle_fail), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub2)
}

@Composable
fun AttendNotAttend() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = KusitmsColorPalette.current.Grey800),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        KusitmsMarginVerticalSpacer(size = 88)
        Text(text = stringResource(R.string.attend_not_attend), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
    }
}

@Composable
fun ScrollBtn(scrollState: ScrollState) {
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        FloatingActionButton(
            modifier = Modifier.padding(16.dp),
            onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollTo(0)
                }
            },
            backgroundColor = Color.Transparent
        ) { Icon(painter = painterResource(id = R.drawable.ic_up_arrow_fill), contentDescription = "Go to top", tint = Color.Unspecified) }
    }
}

@Composable
fun AttendBoxRow(
    viewModel: AttendViewModel
) {
    val attendFlow by viewModel.attendScore.collectAsState()
    val attendCount = attendFlow.present
    val absentCount = attendFlow.absent
    val lateCount = attendFlow.late

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(74.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        AttendBoxItem(title = R.string.attend_box4_attend, Modifier.weight(1f), "${attendCount}회")
        Spacer(Modifier.width(12.dp))

        AttendBoxItem(title = R.string.attend_box4_non_attend, Modifier.weight(1f), "${absentCount}회")
        Spacer(Modifier.width(12.dp))

        AttendBoxItem(title = R.string.attend_box4_non_late, Modifier.weight(1f), "${lateCount}회")
    }
}

@Composable
fun AttendBoxItem(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    text: String
) {
    Box(modifier = modifier
        .height(74.dp)
        .background(
            color = KusitmsColorPalette.current.Grey600,
            shape = RoundedCornerShape(12.dp)
        )
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = title),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey300,
            )
            Text(text = text,
                style = KusitmsTypo.current.SubTitle1_Semibold,
                color = KusitmsColorPalette.current.Grey100,
            )
        }
    }
}