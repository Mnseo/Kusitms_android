package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
import androidx.compose.material.icons.materialPath
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object behance {
    var _vector: ImageVector? = null
    val vector: ImageVector
        get() {
            if (_vector != null) {
                return _vector!!
            }
            _vector = ImageVector.Builder(
                name = "Icon_behance",
                defaultWidth = 200.0.dp,
                defaultHeight = 200.0.dp,
                viewportWidth = 200.0F,
                viewportHeight = 200.0F,
            ).materialPath {
                verticalLineToRelative(0.0F)
                reflectiveQuadToRelative(0.0F, 0.0F)
                reflectiveQuadToRelative(0.00160714F, 0.0F)
                verticalLineToRelative(0.0F)
                verticalLineTo(2.0F)
                verticalLineTo(2.0F)
                horizontalLineTo(13.0F)
                verticalLineToRelative(7.0F)
                verticalLineToRelative(1.0F)
                horizontalLineTo(8.0F)
                horizontalLineToRelative(4.0F)
                verticalLineTo(4.0F)
                verticalLineTo(5.0F)
                horizontalLineTo(7.0F)
                verticalLineTo(5.0F)
                horizontalLineToRelative(622.0F)
                verticalLineTo(6.0F)
                verticalLineToRelative(4.0F)
                verticalLineTo(4.0F)
                verticalLineToRelative(0.0F)
                horizontalLineTo(3.0F)
                horizontalLineTo(7.0F)
                verticalLineTo(5.0F)
                horizontalLineTo(8.0F)
                horizontalLineTo(3.0F)
                verticalLineToRelative(90.0F)
                verticalLineToRelative(6.0F)
                verticalLineToRelative(87.0F)
                verticalLineTo(5.0F)
                verticalLineTo(2.0F)
                verticalLineToRelative(4.0F)
                horizontalLineTo(4.0F)
                verticalLineTo(3.0F)
                verticalLineTo(6.0F)
                horizontalLineToRelative(99.0F)
                verticalLineTo(6.0F)
                horizontalLineToRelative(5.0F)
                verticalLineToRelative(1.0F)
                verticalLineToRelative(2.0F)
                verticalLineTo(7.0F)
                horizontalLineTo(0.0F)
                verticalLineTo(7.0F)
                verticalLineToRelative(5.0F)
                verticalLineToRelative(1.0F)
                verticalLineToRelative(1.0F)
                verticalLineToRelative(0.0F)
                verticalLineTo(4.0F)
                horizontalLineToRelative(0.0F)
                verticalLineTo(0.0F)
                horizontalLineToRelative(4.0F)
                verticalLineToRelative(18.0F)
                verticalLineToRelative(45.0F)
                horizontalLineTo(2.0F)
                verticalLineToRelative(2.0F)
                verticalLineTo(0.0F)
                horizontalLineTo(6.0F)
                verticalLineToRelative(4.0F)
                verticalLineToRelative(5.0F)
                horizontalLineToRelative(0.0F)
                horizontalLineTo(4.0F)
                horizontalLineToRelative(3.0F)
                verticalLineTo(6.0F)
                verticalLineToRelative(7.0F)
                horizontalLineToRelative(4.0F)
                horizontalLineTo(9.0F)
                horizontalLineToRelative(47.0F)
                verticalLineToRelative(0.0F)
                horizontalLineTo(7.0F)
                horizontalLineTo(7.0F)
                verticalLineToRelative(0.0F)
                horizontalLineTo(5.0F)
                verticalLineTo(7.0F)
                verticalLineTo(37.0F)
                horizontalLineTo(7.0F)
                horizontalLineTo(53.0F)
                horizontalLineToRelative(70.0F)
                verticalLineTo(92.0F)
                verticalLineTo(9.0F)
                verticalLineTo(633.0F)
                verticalLineToRelative(7.0F)
                horizontalLineTo(1.0F)
                close()
            }.build()
            return _vector!!
        }


    @Composable
    fun DrawBehance(modifier: Modifier = Modifier) {
        Image(
            imageVector = LeftArrow.vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )

    }
}

@Preview
@Composable
fun behanceDraw() {
    behance.DrawBehance()
}


