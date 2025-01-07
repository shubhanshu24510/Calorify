package com.shubhans.onboarding.presentation.height

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

class HeightViewModel(
    private val preference: Preferences,
    private val filterOutDigit: FitterOutDigit
) : ViewModel() {
    var height by mutableStateOf("180")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(height: String) {
        if (height.length <= 3) {
            this.height = filterOutDigit(height)
        }
    }

    fun OnNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.showSnackbarMessage(
                        UiText.StringResource(R.string.height_can_not_be_empty)
                    )
                )
                return@launch
            }
            preference.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}