package com.shubhans.onboarding.presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.model.Gender
import com.shubhans.domain.prefrences.Preferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GenderScreenViewModel(
    private val preference: Preferences
) : ViewModel() {

    var OnGenderSelected by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun OnGenderSelected(gender: Gender) {
        OnGenderSelected = gender
    }

    fun OnNextClick() {
        viewModelScope.launch {
            preference.saveGender(OnGenderSelected)
            _uiEvent.send(UiEvent.Success)
        }
    }
}