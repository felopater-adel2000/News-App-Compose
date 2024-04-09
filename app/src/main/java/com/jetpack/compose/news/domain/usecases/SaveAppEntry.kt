package com.jetpack.compose.news.domain.usecases

import com.jetpack.compose.news.domain.manager.LocalUserManager

class SaveAppEntry (private val localUserManager: LocalUserManager)
{
    suspend operator fun invoke()
    {
        localUserManager.saveAppEntry()
    }
}