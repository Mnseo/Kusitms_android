import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.profile.detail.ProfileDetailImage
import com.kusitms.presentation.ui.profile.detail.ProfileDetailInfo
import com.kusitms.presentation.ui.profile.detail.ProfileDetailViewModel

@Composable
fun ProfileDetailScreen(
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val profile by viewModel.profile.collectAsStateWithLifecycle()

    Column() {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_detail_topbar),
            onBackClick = {
                onBack()
            }) {
            Text(
                text = "차단",
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900)
        ) {
            item {

            }
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailImage()
                }
            }
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailInfo()
                }
            }
        }
    }

}