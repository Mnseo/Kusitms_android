package com.kusitms.presentation.ui.ImageVector

import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview

object StudyIcon {
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
                    fill = SolidColor(Color(0xFFCCD6DD)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(17.3137f, 17.0679f)
                    curveTo(17.3137f, 17.901f, 16.6383f, 18.5764f, 15.8052f, 18.5764f)
                    horizontalLineTo(7.50849f)
                    curveTo(6.6754f, 18.5764f, 6f, 17.901f, 6f, 17.0679f)
                    verticalLineTo(6.50849f)
                    curveTo(6f, 5.6754f, 6.6754f, 5f, 7.5085f, 5f)
                    horizontalLineTo(15.8052f)
                    curveTo(16.6383f, 5f, 17.3137f, 5.6754f, 17.3137f, 6.5085f)
                    verticalLineTo(17.0679f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF99AAB5)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(15.8053f, 14.051f)
                    curveTo(15.8053f, 14.2595f, 15.6367f, 14.4281f, 15.4281f, 14.4281f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 14.4281f, 7.5085f, 14.2595f, 7.5085f, 14.051f)
                    curveTo(7.5085f, 13.8424f, 7.6775f, 13.6739f, 7.8857f, 13.6739f)
                    horizontalLineTo(15.4281f)
                    curveTo(15.6367f, 13.6739f, 15.8053f, 13.8424f, 15.8053f, 14.051f)
                    close()
                    moveTo(9.77128f, 15.5595f)
                    curveTo(9.7713f, 15.768f, 9.6023f, 15.9366f, 9.3942f, 15.9366f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 15.9366f, 7.5085f, 15.768f, 7.5085f, 15.5595f)
                    curveTo(7.5085f, 15.3509f, 7.6775f, 15.1824f, 7.8857f, 15.1824f)
                    horizontalLineTo(9.39416f)
                    curveTo(9.6023f, 15.1824f, 9.7713f, 15.3509f, 9.7713f, 15.5595f)
                    close()
                    moveTo(15.8053f, 8.01702f)
                    curveTo(15.8053f, 8.2252f, 15.6367f, 8.3941f, 15.4281f, 8.3941f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 8.3941f, 7.5085f, 8.2252f, 7.5085f, 8.017f)
                    curveTo(7.5085f, 7.8088f, 7.6775f, 7.6399f, 7.8857f, 7.6399f)
                    horizontalLineTo(15.4281f)
                    curveTo(15.6367f, 7.6399f, 15.8053f, 7.8088f, 15.8053f, 8.017f)
                    close()
                    moveTo(15.8053f, 9.52551f)
                    curveTo(15.8053f, 9.7341f, 15.6367f, 9.9026f, 15.4281f, 9.9026f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 9.9026f, 7.5085f, 9.7341f, 7.5085f, 9.5255f)
                    curveTo(7.5085f, 9.317f, 7.6775f, 9.1484f, 7.8857f, 9.1484f)
                    horizontalLineTo(15.4281f)
                    curveTo(15.6367f, 9.1484f, 15.8053f, 9.317f, 15.8053f, 9.5255f)
                    close()
                    moveTo(15.8053f, 11.034f)
                    curveTo(15.8053f, 11.2425f, 15.6367f, 11.4111f, 15.4281f, 11.4111f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 11.4111f, 7.5085f, 11.2425f, 7.5085f, 11.034f)
                    curveTo(7.5085f, 10.8255f, 7.6775f, 10.6569f, 7.8857f, 10.6569f)
                    horizontalLineTo(15.4281f)
                    curveTo(15.6367f, 10.6569f, 15.8053f, 10.8255f, 15.8053f, 11.034f)
                    close()
                    moveTo(15.8053f, 12.5425f)
                    curveTo(15.8053f, 12.751f, 15.6367f, 12.9196f, 15.4281f, 12.9196f)
                    horizontalLineTo(7.88567f)
                    curveTo(7.6775f, 12.9196f, 7.5085f, 12.751f, 7.5085f, 12.5425f)
                    curveTo(7.5085f, 12.3339f, 7.6775f, 12.1654f, 7.8857f, 12.1654f)
                    horizontalLineTo(15.4281f)
                    curveTo(15.6367f, 12.1654f, 15.8053f, 12.3339f, 15.8053f, 12.5425f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF66757F)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(17.3137f, 7.36532f)
                    curveTo(17.0018f, 7.1635f, 16.6209f, 7.147f, 16.363f, 7.3566f)
                    lineTo(16.0643f, 7.60026f)
                    lineTo(15.5046f, 8.05696f)
                    lineTo(15.4669f, 8.08713f)
                    lineTo(14.5709f, 8.81799f)
                    lineTo(10.0914f, 12.4708f)
                    curveTo(9.9266f, 12.6054f, 9.7924f, 12.9305f, 9.649f, 13.253f)
                    curveTo(9.5065f, 13.5735f, 9.2836f, 14.3285f, 9.1049f, 14.9089f)
                    curveTo(9.049f, 15.0032f, 8.7032f, 15.6051f, 8.8971f, 15.834f)
                    curveTo(9.0932f, 16.0659f, 9.7743f, 15.8378f, 9.8655f, 15.8053f)
                    curveTo(10.4787f, 15.7397f, 11.2726f, 15.6647f, 11.6184f, 15.5866f)
                    curveTo(11.9668f, 15.507f, 12.3176f, 15.4376f, 12.4824f, 15.303f)
                    curveTo(12.4854f, 15.3007f, 12.4861f, 15.2962f, 12.4888f, 15.2943f)
                    lineTo(16.9607f, 11.6491f)
                    lineTo(17.2594f, 11.4054f)
                    lineTo(17.3137f, 11.3609f)
                    verticalLineTo(7.36532f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFD99E82)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(12.4658f, 13.4951f)
                    curveTo(12.4658f, 13.4951f, 11.9854f, 12.7857f, 11.6674f, 12.5323f)
                    curveTo(11.414f, 12.2144f, 10.7062f, 11.7343f, 10.7062f, 11.7343f)
                    curveTo(10.5372f, 11.5661f, 10.257f, 11.5533f, 10.0918f, 11.7181f)
                    curveTo(9.927f, 11.8833f, 9.7928f, 12.2332f, 9.6495f, 12.5821f)
                    curveTo(9.4715f, 13.0143f, 9.1683f, 14.1486f, 8.9827f, 14.7513f)
                    curveTo(8.9514f, 14.8539f, 9.1777f, 14.5816f, 9.1724f, 14.6721f)
                    curveTo(9.1686f, 14.7426f, 9.1826f, 14.8207f, 9.2003f, 14.8912f)
                    lineTo(9.14525f, 14.9512f)
                    lineTo(9.22369f, 14.9764f)
                    curveTo(9.2331f, 15.0073f, 9.2425f, 15.0345f, 9.2493f, 15.0556f)
                    lineTo(9.3093f, 15.0006f)
                    curveTo(9.3798f, 15.0183f, 9.4579f, 15.0322f, 9.528f, 15.0285f)
                    curveTo(9.6185f, 15.0232f, 9.3459f, 15.2498f, 9.4488f, 15.2182f)
                    curveTo(10.0515f, 15.0322f, 11.1862f, 14.7294f, 11.618f, 14.5514f)
                    curveTo(11.9665f, 14.4077f, 12.3172f, 14.2738f, 12.482f, 14.1087f)
                    curveTo(12.6476f, 13.9446f, 12.6351f, 13.6644f, 12.4658f, 13.4951f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFEA596E)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(15.1687f, 6.64094f)
                    curveTo(14.8383f, 6.9709f, 14.8383f, 7.5057f, 15.1687f, 7.8357f)
                    lineTo(16.363f, 9.0304f)
                    curveTo(16.6934f, 9.36f, 17.2281f, 9.36f, 17.5577f, 9.0304f)
                    lineTo(18.7528f, 7.83567f)
                    curveTo(19.0825f, 7.5057f, 19.0825f, 6.9709f, 18.7528f, 6.6409f)
                    lineTo(17.5577f, 5.44622f)
                    curveTo(17.2281f, 5.1162f, 16.6934f, 5.1162f, 16.363f, 5.4462f)
                    lineTo(15.1687f, 6.64094f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFFCC4D)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(10.0913f, 11.7184f)
                    lineTo(11.2868f, 12.9139f)
                    lineTo(12.4804f, 14.1078f)
                    lineTo(16.961f, 9.62798f)
                    lineTo(14.5712f, 7.23853f)
                    lineTo(10.0913f, 11.7184f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF292F33)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(9.88355f, 15.0851f)
                    curveTo(9.8835f, 15.0851f, 9.1067f, 15.5124f, 8.897f, 15.3023f)
                    curveTo(8.6869f, 15.0919f, 9.1161f, 14.3176f, 9.1161f, 14.3176f)
                    curveTo(9.1161f, 14.3176f, 9.8519f, 14.3312f, 9.8835f, 15.0851f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFCCD6DD)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(14.5713f, 7.23828f)
                    lineTo(16.0647f, 5.74487f)
                    lineTo(18.4541f, 8.1347f)
                    lineTo(16.9607f, 9.62811f)
                    lineTo(14.5713f, 7.23828f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF99AAB5)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(15.4669f, 6.34189f)
                    lineTo(15.7655f, 6.04321f)
                    lineTo(18.155f, 8.43229f)
                    lineTo(17.8563f, 8.73097f)
                    lineTo(15.4669f, 6.34189f)
                    close()
                    moveTo(14.8699f, 6.93926f)
                    lineTo(15.1682f, 6.64095f)
                    lineTo(17.5576f, 9.03003f)
                    lineTo(17.2589f, 9.32871f)
                    lineTo(14.8699f, 6.93926f)
                    close()
                }
            }.build()

            return _vector!!
        }

    @Composable
    fun drawStudyIcon(modifier: Modifier = Modifier) {
        Image(
            imageVector = vector,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
fun previewIcon() {
    StudyIcon.drawStudyIcon()
}



