package com.shubhans.onboarding.presentation.nutrient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.core.presentation.utils.UiEvent.*
import com.shubhans.domain.prefrences.Prefrences
import com.shubhans.domain.usecases.FitterOutDigit
import com.shubhans.onboarding.domain.use_cases.ValidateNutrients
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NutrientViewModel(
    private val prefrences: Prefrences,
    private val filterOutDigit: FitterOutDigit,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {
    var state by mutableStateOf(NutrientGoalState())
        private set

    val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: NutrientGoalAction){
        when (action) {
            is NutrientGoalAction.enterCarbonRatio -> {
                state.copy(
                    carbonValue = filterOutDigit(state.carbonValue)
                )
            }

            is NutrientGoalAction.enterFatRatio -> {
                state.copy(
                    carbonValue = filterOutDigit(state.proteinsValue)
                )
            }

            is NutrientGoalAction.enterProteinRatio -> {
                state.copy(
                    carbonValue = filterOutDigit(state.fatsValue)
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
                        prefrences.saveCarbsRatio(carbsRatio = result.carbsRatio)
                        prefrences.saveProteinsRatio(proteinsRatio = result.proteinsRatio)
                        prefrences.saveFatsRatio(fatsRatio = result.fatsRatio)
                        viewModelScope.launch {
                            _uiEvent.send(Success)
                        }
                    }

                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch {
                            _uiEvent.send(
                                showSnackbarMessage(
                                    result.message.toString()
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}