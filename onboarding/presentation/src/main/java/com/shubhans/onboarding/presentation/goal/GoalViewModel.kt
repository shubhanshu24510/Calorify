package com.shubhans.onboarding.presentation.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.model.GoalType
import com.shubhans.domain.prefrences.Preferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GoalViewModel(
    private val prefrences: Preferences
) : ViewModel() {
    var selectedGoalType by mutableStateOf<GoalType>(GoalType.Keep)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalLevelSelected(goalType: GoalType) {
        selectedGoalType = goalType
    }

    fun OnNextClick() {
        viewModelScope.launch {
            prefrences.saveGoal(selectedGoalType)
            _uiEvent.send(UiEvent.Success)
        }
    }
}