package com.jetpack.compose.news.domain.usecases

import com.jetpack.compose.news.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (private val localUserManager: LocalUserManager) {

    operator fun invoke(): Flow<Boolean>
    {
        return localUserManager.readAppEntry()
    }
}