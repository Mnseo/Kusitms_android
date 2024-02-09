package com.kusitms.presentation.ui.home.attend.camera

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.view.Surface
import android.view.ViewGroup
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.BlendMode.Companion.Overlay
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.google.zxing.*
import com.google.zxing.common.HybridBinarizer
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.home.attend.AttendViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CameraScreen(
    viewModel: AttendViewModel,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarContentState = remember { mutableStateOf<Pair<AttendViewModel.AttendSnackBarEvent, String>>(AttendViewModel.AttendSnackBarEvent.None to "") }

    LaunchedEffect(key1 = Unit) {
        viewModel.snackbarEvent.collect { event ->
            val message = when (event) {
                AttendViewModel.AttendSnackBarEvent.Attend_success -> "출석이 완료되었습니다"
                AttendViewModel.AttendSnackBarEvent.Attend_fail -> "QR코드를 다시 확인해주세요"
                else -> "화면 정가운데에 QR코드를 스캔해주세요"
            }
            snackbarContentState.value = event to message
        }
    }
    ComposablePermission(
        permission = Manifest.permission.CAMERA,
        onDenied = { requester ->
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "카메라 권한이 필요합니다.")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = requester) {
                    Text(text = "권한 요청")
                }
            }
        },
        onGranted = {
            val onQrCodeScanned: (String) -> Unit = { qrText ->
                if(qrText != "") {
                    viewModel.updateScannedQrCode(qrText)
                    viewModel.postAttendCheck()
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                CameraSnackbar(snackbarHostState = snackbarHostState) {
                    val (event, message) = snackbarContentState.value
                    when (event) {
                        AttendViewModel.AttendSnackBarEvent.Attend_success -> {
                            Text(text = message, style= KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey200)
                        }
                        AttendViewModel.AttendSnackBarEvent.Attend_fail -> {
                                Image(painterResource(id = R.drawable.ic_warning_sigb), contentDescription = null)
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(text = message, style= KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Sub2)
                        }
                        else -> {  Text(text = message, style= KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey200) }
                    }
                }
            }
            CameraPreview(viewModel = viewModel, onQrCodeScanned = onQrCodeScanned)
        }
    )
}

@Composable
fun CameraSnackbar(
    snackbarHostState: SnackbarHostState,
    content: @Composable () -> Unit
) {
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxWidth(),
        snackbar = { snackbarData ->
            Box(modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey600,
                    shape = RoundedCornerShape(12.dp)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    content()
                }
            }
        })
}

@Composable
fun CameraOverlay() {
    Canvas(modifier = Modifier
        .fillMaxSize()
        .graphicsLayer(alpha = 0.99f)
    ) {
        val rectSize = Size(size.width * 0.568f, size.width * 0.568f)

        drawPath(
            createCornersPath(
                left = (size.width - rectSize.width) / 2f,
                top = (size.height - rectSize.width) / 2f,
                right = (size.width - rectSize.width) / 2f + rectSize.height,
                bottom = (size.height - rectSize.width) / 2f + rectSize.width,
                cornerRadius = 40f,
                cornerLength = 40f
            ),
            color = Color.White,
            style = Stroke(width = 10f)
        )
    }
}

@Composable
fun ComposablePermission(
    permission: String,
    onDenied: @Composable (requester: () -> Unit) -> Unit,
    onGranted: @Composable () -> Unit
) {
    val ctx = LocalContext.current

    // check initial state of permission, it may be already granted
    var grantState by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                ctx,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        )
    }
    if (grantState) {
        onGranted()
    } else {
        val launcher: ManagedActivityResultLauncher<String, Boolean> =
            rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) {
                grantState = it
            }
        onDenied { launcher.launch(permission) }
    }
}


private fun createCornersPath(
    left: Float,
    top: Float,
    right: Float,
    bottom: Float,
    cornerRadius: Float,
    cornerLength: Float
): Path {
    val path = Path()

    // top left
    path.moveTo(left, (top + cornerRadius))
    path.arcTo(
        Rect(left = left, top = top, right = left + cornerRadius, bottom = top + cornerRadius),
        180f,
        90f,
        true
    )

    path.moveTo(left + (cornerRadius / 2f), top)
    path.lineTo(left + (cornerRadius / 2f) + cornerLength, top)

    path.moveTo(left, top + (cornerRadius / 2f))
    path.lineTo(left, top + (cornerRadius / 2f) + cornerLength)

    // top right
    path.moveTo(right - cornerRadius, top)
    path.arcTo(
        Rect(left = right - cornerRadius, top = top, right = right, bottom = top + cornerRadius),
        270f,
        90f,
        true
    )

    path.moveTo(right - (cornerRadius / 2f), top)
    path.lineTo(right - (cornerRadius / 2f) - cornerLength, top)

    path.moveTo(right, top + (cornerRadius / 2f))
    path.lineTo(right, top + (cornerRadius / 2f) + cornerLength)

    // bottom left
    path.moveTo(left, bottom - cornerRadius)
    path.arcTo(
        Rect(left = left, top = bottom - cornerRadius, right = left+cornerRadius, bottom = bottom),
        90f,
        90f,
        true
    )

    path.moveTo(left + (cornerRadius / 2f), bottom)
    path.lineTo(left + (cornerRadius / 2f) + cornerLength, bottom)

    path.moveTo(left, bottom - (cornerRadius / 2f))
    path.lineTo(left, bottom - (cornerRadius / 2f) - cornerLength)

    // bottom right
    path.moveTo(left, bottom - cornerRadius)
    path.arcTo(
        Rect(left = right - cornerRadius, top = bottom - cornerRadius, right = right, bottom = bottom),
        0f,
        90f,
        true
    )

    path.moveTo(right - (cornerRadius / 2f), bottom)
    path.lineTo(right - (cornerRadius / 2f) - cornerLength, bottom)

    path.moveTo(right, bottom - (cornerRadius / 2f))
    path.lineTo(right, bottom - (cornerRadius / 2f) - cornerLength)

    return path
}

@Composable
@androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
fun CameraPreview(viewModel: AttendViewModel, onQrCodeScanned: (String) -> Unit) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val previewView = remember { PreviewView(context) }
    val qrEnabled by viewModel.qrEnabled.collectAsState()
    val preview = Preview.Builder().build().also {
        it.setSurfaceProvider(previewView.surfaceProvider)
    }

    // QR 코드 스캐너 설정
    val imageAnalysis = ImageAnalysis.Builder()
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
        .also {
            it.setAnalyzer(ContextCompat.getMainExecutor(context)) { imageProxy ->
                if(qrEnabled) {
                    val image = imageProxy.image
                    if (image != null) {
                        val buffer = image.planes[0].buffer
                        val bytes = ByteArray(buffer.remaining())
                        buffer.get(bytes)
                        val source = PlanarYUVLuminanceSource(
                            bytes, image.width, image.height, 0, 0, image.width, image.height, false
                        )
                        val binaryBitmap = BinaryBitmap(HybridBinarizer(source))
                        try {
                            val reader = MultiFormatReader().apply {
                                val hints = mapOf<DecodeHintType, Any>(
                                    DecodeHintType.POSSIBLE_FORMATS to listOf(
                                        BarcodeFormat.QR_CODE
                                    )
                                )
                                setHints(hints)
                            }
                            val result = reader.decode(binaryBitmap)
                            val qrText = result.text
                            onQrCodeScanned(qrText)
                        } catch (e: NotFoundException) {
                            // QR 코드를 찾지 못함
                        } finally {
                            imageProxy.close()
                        }
                    }
                } else {
                    imageProxy.close()
                }
            }
        }

    // 카메라 시작
    LaunchedEffect(previewView) {
        val cameraProvider = cameraProviderFuture.get()
        cameraProvider.unbindAll() // 기존 바인딩 제거

        try {
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                CameraSelector.DEFAULT_BACK_CAMERA,
                preview,
                imageAnalysis
            )
        } catch (e: Exception) {
            Log.e("CameraPreview", "카메라 시작 실패", e)
        }
    }

    AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
    CameraOverlay()
}

