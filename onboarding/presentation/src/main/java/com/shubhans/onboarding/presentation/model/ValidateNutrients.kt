package com.shubhans.onboarding.presentation.model

import com.shubhans.core.presentation.utils.UiText
import com.shubhans.onboarding.presentation.R

class ValidateNutrients {
    operator fun invoke(
        carbsRatioText: String,
        proteinsRatioText: String,
        fatsRatioText: String
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinsRatio = proteinsRatioText.toIntOrNull()
        val fatsRatio = fatsRatioText.toIntOrNull()

        if (carbsRatio == null || proteinsRatio == null ||  fatsRatio == null) {
            return Result.Error(
                UiText.StringResource(R.string.please_enter_valid_values)
            )
        }

        if (carbsRatio + proteinsRatio + fatsRatio != 100) {
            return Result.Error(
                UiText.StringResource(R.string.sum_of_ratios_should_be_100)
            )
        }
        return Result.Success(
            carbsRatio = carbsRatio / 100f,
            proteinsRatio = proteinsRatio / 100f,
            fatsRatio = fatsRatio / 100f
        )
    }

    sealed class Result {
        data class Success(
            val carbsRatio: Float,
            val proteinsRatio: Float,
            val fatsRatio: Float
        ) : Result()

        data class Error(val message: UiText ) : Result()
    }
}