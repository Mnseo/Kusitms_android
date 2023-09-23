package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object rocket {
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

            }.build()
            return _vector!!
        }

    @Composable
    fun DrawRightArrow(modifier: Modifier = Modifier) {
        Image(
            imageVector = RightArrow.vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun previewRocket() {
    rocket.DrawRightArrow()
}