package com.kusitms.presentation.common.util

import android.app.DownloadManager
import android.net.Uri
import java.io.File

object FileDownloadUtil {
    fun downloadImage(
        downloadManager: DownloadManager,
        url : String,
        file : File?,
        onError : () -> Unit
    ) {
        try {
            val targetFile = File(file, "/Kusitms/kusitms_${System.currentTimeMillis()}.png")

            val request = DownloadManager.Request(Uri.parse(url))
                .setTitle("이미지 다운로드")
                .setDescription("Downloading")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationUri(Uri.fromFile(targetFile))
                .setRequiresCharging(false)
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)

            downloadManager.enqueue(request)
        }catch (e: Exception){
            onError()
        }
    }
}