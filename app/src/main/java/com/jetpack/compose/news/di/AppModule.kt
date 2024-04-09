package com.jetpack.compose.news.di

import android.app.Application
import com.jetpack.compose.news.data.manager.LocalUserManagerImp
import com.jetpack.compose.news.domain.manager.LocalUserManager
import com.jetpack.compose.news.domain.usecases.AppEntryUseCases
import com.jetpack.compose.news.domain.usecases.ReadAppEntry
import com.jetpack.compose.news.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImp(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}