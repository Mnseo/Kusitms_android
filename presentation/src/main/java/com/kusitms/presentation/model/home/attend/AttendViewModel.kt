package com.kusitms.presentation.model.home.attend

import androidx.compose.ui.graphics.Color
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AttendViewModel @Inject constructor(

) {
    enum class Status {
        PRESENT, ABSENT, LATE;

        companion object {
            fun fromString(status: String): Status? {
                return values().find { it.name == status }
            }
        }

        fun toDrawable(): Int {
            return when (this) {
                PRESENT -> R.drawable.ic_attend_check
                ABSENT -> R.drawable.ic_attend_non_check
                LATE -> R.drawable.ic_attend_late
            }
        }
    }


}