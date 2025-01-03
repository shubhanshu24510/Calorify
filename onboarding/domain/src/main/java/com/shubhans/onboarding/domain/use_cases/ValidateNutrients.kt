package com.shubhans.onboarding.domain.use_cases

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
            return Result.Error("There are not valid values")
        }

        if (carbsRatio + proteinsRatio + fatsRatio != 100) {
            return Result.Error("The values must add up to 100%")
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

        data class Error(val message: String) : Result()
    }
}