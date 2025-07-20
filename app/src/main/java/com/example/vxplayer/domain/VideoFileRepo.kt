package com.example.vxplayer.domain

import android.app.Application
import com.example.vxplayer.data.models.VideoFile
import kotlinx.coroutines.flow.Flow

interface VideoFileRepo {
    suspend fun getAllVideos(application: Application) : Flow<ArrayList<VideoFile>>
    suspend fun getAllFolders(application: Application) : Flow<Map<String , List<VideoFile>>>
}