package com.shubhans.tracker.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.CarbColor
import com.shubhans.core.presentation.design_system.FatColor
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.core.presentation.design_system.MediumGray
import com.shubhans.core.presentation.design_system.ProteinColor

@Composable
fun HeaderBar(
    carbsRatio: Int,
    proteinsRatio: Int,
    fatsRatio: Int,
    caloriesGoal: Int,
    calories: Int,
    modifier: Modifier = Modifier,
) {
    val caloriesExceedColor = MaterialTheme.colorScheme.error
    val background = MediumGray

    val carbsWidthRatio = remember {
        Animatable(0f)
    }
    val proteinsWidthRatio = remember {
        Animatable(0f)
    }
    val fatsWidthRatio = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = carbsRatio) {
        carbsWidthRatio.animateTo(
            targetValue = ((carbsRatio * 4f) / caloriesGoal)
        )
    }
    LaunchedEffect(key1 = proteinsRatio) {
        proteinsWidthRatio.animateTo(
            targetValue = ((proteinsRatio * 4f) / caloriesGoal)
        )
    }
    LaunchedEffect(key1 = fatsRatio) {
        fatsWidthRatio.animateTo(
            targetValue = ((fatsRatio * 4f) / caloriesGoal)
        )
    }

    Canvas(modifier = modifier) {
        if (calories <= caloriesGoal) {
            val carbsWidth = size.width * carbsWidthRatio.value
            val proteinsWidth = size.width * proteinsWidthRatio.value
            val fatsWidth = size.width * fatsWidthRatio.value
            drawRoundRect(
                color = background,
                size = size,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                size = size.copy(
                    width = carbsWidth + proteinsWidth + fatsWidth,
                    height = size.height
                ),
                color = FatColor,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                size = size.copy(
                    width = carbsWidth + proteinsWidth,
                    height = size.height
                ),
                color = ProteinColor,
                cornerRadius = CornerRadius(100f)
            )
            drawRoundRect(
                size = size.copy(
                    width = carbsWidth,
                    height = size.height
                ),
                color = CarbColor,
                cornerRadius = CornerRadius(100f)
            )
        } else {
            drawRoundRect(
                size = size,
                color = caloriesExceedColor,
                cornerRadius = CornerRadius(100f)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderBarPreview() {
    CalorifyTheme {
        HeaderBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            carbsRatio = 30,
            proteinsRatio = 70,
            fatsRatio = 10,
            caloriesGoal = 2000,
            calories = 1900
        )
    }
}
