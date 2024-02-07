import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.kusitms.presentation.model.profile.detail.ProfileDetailViewModel
import com.kusitms.presentation.ui.profile.detail.ProfileDetailImage
import com.kusitms.presentation.ui.profile.detail.ProfileDetailInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun ProfileDetailScreen(
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onClickModify: () -> Unit
) {
    val profile by viewModel.profile.collectAsStateWithLifecycle()
    val isMember = viewModel.infoProfile

    Column {
        KusitsmTopBarBackTextWithIcon(
            text = if (isMember.email == profile.email) {
                stringResource(id = R.string.profile_my_detail_topbar, profile.name)
            } else {
                stringResource(id = R.string.profile_detail_topbar, profile.name)
            },
            onBackClick = {
                onBack()
            }) {
            // 내 프로필인지 판단해서 수정 혹은 차단 띄우기
            if (isMember.email == profile.email) {
                Text(
                    text = stringResource(id = R.string.profile_detail_edit),
                    style = KusitmsTypo.current.Text_Medium,
                    color = KusitmsColorPalette.current.Main400,
                    modifier = Modifier.clickable {
                        onClickModify()
                    }
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900)
        ) {
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailImage(
                        profile.name,
                        profile.profileImage,
                        profile.period,
                        profile.part,
                        profile.description,
                    )
                }
            }
            item {
                Box(modifier = Modifier.padding(horizontal = 32.dp, vertical = 8.dp)) {
                    ProfileDetailInfo(
                        profile.major,
                        profile.interests,
                        profile.email,
                        profile.phoneNumber,
                        profile.links
                    )
                }
            }
        }
    }
}

