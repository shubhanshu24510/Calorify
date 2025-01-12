package com.shubhans.onboarding.presentation.nutrient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.prefrences.Preferences
import com.shubhans.domain.usecases.FitterOutDigit
import com.shubhans.onboarding.presentation.model.ValidateNutrients
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NutrientViewModel(
    private val preferences: Preferences,
    private val filterOutDigit: FitterOutDigit,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {
    var state by mutableStateOf(NutrientGoalState())
        private set

    val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: NutrientGoalAction) {
        when (action) {
            is NutrientGoalAction.enterCarbonRatio -> {
                state = state.copy(
                    carbonValue = filterOutDigit(action.ratio)
                )
            }

            is NutrientGoalAction.enterFatRatio -> {
                state = state.copy(
                    fatsValue = filterOutDigit(action.ratio)
                )
            }

            is NutrientGoalAction.enterProteinRatio -> {
                state = state.copy(
                    proteinsValue = filterOutDigit(action.ratio)
                )
            }

            NutrientGoalAction.OnNextClick -> {
                val result = validateNutrients(
                    carbsRatioText = state.carbonValue,
                    fatsRatioText = state.fatsValue,
                    proteinsRatioText = state.proteinsValue
                )
                when (result) {
                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbsRatio(carbsRatio = result.carbsRatio)
                        preferences.saveProteinsRatio(proteinsRatio = result.proteinsRatio)
                        preferences.saveFatsRatio(fatsRatio = result.fatsRatio)
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.Success)
                        }
                    }

                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(UiEvent.showSnackbarMessage(result.message))
                        }
                    }
                }
            }
        }
    }
}