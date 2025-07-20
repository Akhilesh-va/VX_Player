package com.example.vxplayer.di

import com.example.vxplayer.data.Repository.VideoFileRepoImpl
import com.example.vxplayer.domain.VideoFileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object Module {

    @Singleton
    @Provides
    fun provideVideoFileRepo(): VideoFileRepo {
        return VideoFileRepoImpl()

    }
}