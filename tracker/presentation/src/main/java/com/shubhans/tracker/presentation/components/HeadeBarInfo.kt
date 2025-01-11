package com.shubhans.tracker.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.DarkGray
import com.shubhans.tracker.presentation.R

@Composable
fun NutritionBarInfo(
    name: String,
    value: Int,
    color: Color,
    goal: Int,
    strokeWidth: TextUnit = 8.sp,
    modifier: Modifier = Modifier
) {
    val background = MaterialTheme.colorScheme.background
    val goalExceededColor = MaterialTheme.colorScheme.error
    val angleRatio = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        angleRatio.animateTo(
            targetValue = if (goal > 0) {
                value / goal.toFloat()
            } else 0f, animationSpec = tween(
                durationMillis = 300
            )
        )
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            drawArc(
                color = if (value <= goal) background else goalExceededColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                size = size,
                style = Stroke(
                    strokeWidth.toPx(), cap = StrokeCap.Round
                )
            )
            if (value <= goal) {
                drawArc(
                    color = color,
                    startAngle = 90f,
                    sweepAngle = 360f * angleRatio.value,
                    useCenter = false,
                    size = size,
                    style = Stroke(
                        width = strokeWidth.toPx(), cap = StrokeCap.Round
                    )
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderUnit(
                amount = value,
                unit = stringResource(R.string.grams),
                amountTextColor = if (value <= goal) Color.White else goalExceededColor,
                unitTextColor = if (value <= goal) Color.White else goalExceededColor,
            )
            Text(
                text = name,
                color = if (value <= goal) Color.White else goalExceededColor,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Light
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NutritionBarInfoPreview() {
    CalorifyTheme {
        NutritionBarInfo(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .size(90.dp),
            name = "Carbs",
            value = 0,
            color = DarkGray,
            goal = 200
        )
    }
}