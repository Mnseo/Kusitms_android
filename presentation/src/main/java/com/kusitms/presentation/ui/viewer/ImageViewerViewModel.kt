package com.kusitms.presentation.ui.viewer

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ImageViewerViewModel @Inject constructor() : ViewModel() {

    private val _imageList = MutableStateFlow<List<String>>(emptyList())
    val imageList : StateFlow<List<String>> = _imageList.asStateFlow()

    fun updateImageList(images : List<String>){
        _imageList.value = images
    }

    fun clearImageList() {
        _imageList.value = emptyList()
    }
}