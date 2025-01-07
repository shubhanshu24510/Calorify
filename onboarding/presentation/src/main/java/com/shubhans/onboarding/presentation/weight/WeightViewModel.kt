package com.shubhans.onboarding.presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.core.presentation.utils.UiText
import com.shubhans.domain.prefrences.Preferences
import com.shubhans.onboarding.presentation.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class WeightViewModel(
    private val preference: Preferences
) : ViewModel() {

    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onWeightEnter(weight: String) {
        if (weight.length <= 5) {
            this.weight = weight
        }
    }

    fun OnNextClick() {
        viewModelScope.launch {
            val WeightNumber = weight.toFloatOrNull() ?: run {
                _uiEvent.send(
                    UiEvent.showSnackbarMessage(
                        UiText.StringResource(R.string.weight_cant_be_empty)
                    )
                )
                return@launch
            }
            preference.saveWeight(WeightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}