package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.findPw.FindPwViewModel
import com.kusitms.presentation.ui.login.findPw.component.FindPwEmailComval
import com.kusitms.presentation.ui.signIn.KusitmsInputField


@Composable
fun FindPwCodeValidation(viewModel: FindPwViewModel, navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPw2Column(viewModel = viewModel)
    }
}

@Composable
fun FindPw2Column(viewModel: FindPwViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(176.5.dp))
        FindPwEmailComval(text = R.string.find_pw_caption_email, validStr = FindPwViewModel().email.toString())
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(id = R.string.find_pw_caption4), style = KusitmsTypo.current.Caption1, color = KusitmsColorPalette.current.Grey400)
        FindPw2GetCode(viewModel = viewModel)
    }
}

@Composable
fun FindPw2GetCode(viewModel: FindPwViewModel) {
    val code by viewModel.code.collectAsState()
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey700),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start)
        ) {
            KusitmsInputField(text = R.string.find_pw_placeholder4, value = code, onValueChange = {viewModel.updateCode(it)})

        }
    }
}


@Preview
@Composable
fun previewSetNewPw() {
    FindPwCodeValidation(FindPwViewModel(),rememberNavController())
}

