package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.kusitms.presentation.R

@Composable
fun ImagePhoto() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(R.drawable.screen2_photo, imageLoader),
        contentDescription = null,
        modifier = Modifier
            .padding(0.83333.dp)
            .width(44.dp)
            .height(44.dp)
    )
}

@Composable
fun plusIcon() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(R.drawable.ic_plus, imageLoader),
        contentDescription = null,
        contentScale = ContentScale.None,
        modifier = Modifier
            .width(20.dp)
            .height(20.dp)
    )
}

object trashCan {
    public var _vector: ImageVector? = null
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
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = SolidColor(Color(0xFF363C48)),
                    strokeAlpha = 1f,
                    strokeLineWidth = 1.5f,
                    strokeLineCap = StrokeCap.Round,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(19f, 9f)
                    lineTo(18.2841f, 18.3068f)
                    curveTo(18.1238f, 20.3908f, 16.386f, 22f, 14.2959f, 22f)
                    horizontalLineTo(9.70412f)
                    curveTo(7.614f, 22f, 5.8762f, 20.3908f, 5.7159f, 18.3068f)
                    lineTo(5f, 9f)
                    moveTo(21f, 7f)
                    curveTo(18.4021f, 5.734f, 15.3137f, 5f, 12f, 5f)
                    curveTo(8.6863f, 5f, 5.5979f, 5.734f, 3f, 7f)
                    moveTo(10f, 5f)
                    verticalLineTo(4f)
                    curveTo(10f, 2.8954f, 10.8954f, 2f, 12f, 2f)
                    curveTo(13.1046f, 2f, 14f, 2.8954f, 14f, 4f)
                    verticalLineTo(5f)
                    moveTo(10f, 11f)
                    verticalLineTo(17f)
                    moveTo(14f, 11f)
                    verticalLineTo(17f)
                }
            }.build()
            return _vector!!
        }
    @Composable
    fun drawTrashCan(modifier: Modifier = Modifier) {
        Image(
            imageVector = trashCan.vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }
}