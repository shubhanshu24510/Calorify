package com.shubhans.onboarding.presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.model.ActivityLevel
import com.shubhans.domain.prefrences.Preferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ActivityViewModel(
    private val prefrences: Preferences
) : ViewModel() {
    var selectedActivityLevel by mutableStateOf<ActivityLevel>(ActivityLevel.Medium)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onActivityLevelSelected(level: ActivityLevel) {
        selectedActivityLevel = level
    }

    fun OnNextClick() {
        viewModelScope.launch {
            prefrences.saveActivityLevel(selectedActivityLevel)
            _uiEvent.send(UiEvent.Success)
        }
    }
}