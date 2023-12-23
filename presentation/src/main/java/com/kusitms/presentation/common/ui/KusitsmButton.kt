package com.kusitms.presentation.common.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.ui.ImageVector.icons.KusitmsIcons
import com.kusitms.presentation.ui.ImageVector.icons.kusitmsicons.ArrowDown

@Composable
fun BoxScope.KusitsmScrollToTopButton(
    modifier: Modifier = Modifier,
    isVisible : Boolean,
    onClick: () -> Unit
) {
    AnimatedVisibility(
        modifier = modifier,
        visible = isVisible, enter = fadeIn(), exit = fadeOut()
    ) {
        FloatingActionButton(
            modifier = Modifier.size(40.dp),
            containerColor = KusitmsColorPalette.current.Grey600,
            contentColor = KusitmsColorPalette.current.Grey300,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            onClick = onClick
        ) {
            Icon(
                modifier = Modifier.rotate(180f),
                imageVector = KusitmsIcons.ArrowDown,
                contentDescription = null)
        }
    }
}