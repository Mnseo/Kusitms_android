package com.kusitms.presentation.ui.viewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kusitms.presentation.ui.notice.detail.NoticeDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewerViewModel @Inject constructor() : ViewModel() {

    private val _imageList = MutableStateFlow<List<String>>(emptyList())
    val imageList : StateFlow<List<String>> = _imageList.asStateFlow()

    private val _snackbarEvent = MutableSharedFlow<ImageViewerSnackbarEvent>()
    val snackbarEvent : SharedFlow<ImageViewerSnackbarEvent> = _snackbarEvent.asSharedFlow()

    var selectedIndex = 0

    fun updateImageList(images : List<String>){
        _imageList.value = images
    }

    fun clearImageList() {
        _imageList.value = emptyList()
    }

    fun emitSnackbarEvent(imageViewerSnackbarEvent : ImageViewerSnackbarEvent){
        viewModelScope.launch {
            _snackbarEvent.emit(imageViewerSnackbarEvent)
        }
    }

    companion object {
        enum class ImageViewerSnackbarEvent {
            DOWNLOAD_ERROR
        }
    }
}