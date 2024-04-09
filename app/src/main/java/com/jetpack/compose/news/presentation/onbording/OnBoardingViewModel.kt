package com.jetpack.compose.news.presentation.onbording

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.compose.news.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
     val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    private fun saveAppEntry()
    {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }

    fun onEvent(event: OnBoardingEvent)
    {
        when(event)
        {
            OnBoardingEvent.SaveAppEntry -> saveAppEntry()

        }
    }

}