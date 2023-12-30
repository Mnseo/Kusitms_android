import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.Profile
import com.kusitms.presentation.ui.profile.detail.ProfileDetailImage
import com.kusitms.presentation.ui.profile.detail.ProfileDetailInfo

@Composable
fun ProfileDetailScreen(
    onProfileClick: (Profile) -> Unit,
    onBack: () -> Unit,
) {
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileDetailScreenPreview() {
    ProfileDetailScreen(
        onProfileClick = {},
        onBack = {}
    )
}
