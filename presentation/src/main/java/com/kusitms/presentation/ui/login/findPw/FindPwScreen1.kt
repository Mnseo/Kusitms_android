package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.login.findPw.FindPwViewModel


@Composable
fun FindPwScreen1() {
    val viewModel: FindPwViewModel = viewModel()
    val pw by viewModel.pw.observeAsState("")
    val isValid by viewModel.isValid.observeAsState(false)

    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = rememberNavController()
    ) {
        FindPw1Column(pw, isValid,
            onIdChange = {viewModel.pw.value = it}
        )
    }
}

@Composable
fun FindPw1Column(id: String, isValid:Boolean, onIdChange: (String) -> Unit) {
    var example by remember { mutableStateOf("examples") }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey800)
            .padding(horizontal = 20.dp),
            horizontalAlignment =  Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(148.dp))
            FindPwPwInput(pw = id, onPwChange = onIdChange)
            Spacer(modifier = Modifier.weight(1f))
            FindPwBtn1(isValid)
            Spacer(modifier = Modifier.height(24.dp))
        }
}




@Preview
@Composable
fun PreviewFindPw1() {
    FindPwScreen1()
}
