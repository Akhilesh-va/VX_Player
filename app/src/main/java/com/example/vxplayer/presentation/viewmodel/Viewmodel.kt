package com.example.vxplayer.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vxplayer.data.Repository.VideoFileRepoImpl
import com.example.vxplayer.data.models.VideoFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class Viewmodel @Inject constructor(val repo: VideoFileRepoImpl, val application: Application) :
    ViewModel() {

    val showUi = MutableStateFlow(false)
    val folderList = MutableStateFlow(emptyMap<String, List<VideoFile>>())
    val videoList = MutableStateFlow(emptyList<VideoFile>())

    var isLoading = MutableStateFlow(false)

    fun loadVideoFiles() {
        isLoading.value = true
        viewModelScope.launch {
            repo.getAllVideos(application).collectLatest {
                videoList.value = it

            }

        }
            isLoading.value = false


    }

    fun loadFolderFiles() {
        isLoading.value = true
        viewModelScope.launch {
            repo.getAllFolders(application).collectLatest {
                folderList.value = it

            }
        }
            isLoading.value = false

    }

    init {
        viewModelScope.launch {
            loadVideoFiles()
            loadFolderFiles()
        }
    }
}

