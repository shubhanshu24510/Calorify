package com.shubhans.onboarding.presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.core.presentation.utils.UiText
import com.shubhans.domain.prefrences.Preferences
import com.shubhans.domain.usecases.FitterOutDigit
import com.shubhans.onboarding.presentation.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AgeScreenViewModel(
    private val preference: Preferences,
    private val filterOutDigit: FitterOutDigit
) : ViewModel() {
    var age by mutableStateOf("20")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(age: String) {
        if (age.length <= 3) {
            this.age = filterOutDigit(age)
        }
    }

    fun OnNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.showSnackbarMessage(
                        UiText.StringResource(R.string.age_cant_be_empty)
                    )
                )
                return@launch
            }
            preference.saveAge(ageNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}