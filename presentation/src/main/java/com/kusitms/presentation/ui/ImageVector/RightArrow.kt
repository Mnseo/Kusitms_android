package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
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

object RightArrow {
    var _vector: ImageVector? = null
    val vector: ImageVector
        get() {
            if (_vector != null) {
                return _vector!!
            }
            _vector = ImageVector.Builder(
                name = "vector",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f
            ).apply {
                group {
                    path(
                        fill = null,
                        fillAlpha = 1.0f,
                        stroke = SolidColor(Color(0xFF727783)),
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 2f,
                        strokeLineCap = StrokeCap.Round,
                        strokeLineJoin = StrokeJoin.Round,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(10.6667f, 5.33325f)
                        lineTo(5.33341f, 11.9999f)
                        lineTo(10.6667f, 18.6666f)
                    }
                }
            }.build()
            return _vector!!
        }


    @Composable
    fun DrawRightArrow(modifier: Modifier = Modifier) {
        Image(
            imageVector = vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun previewArrow() {
    RightArrow.DrawRightArrow()
}