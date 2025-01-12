package com.shubhans.tracker.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.core.presentation.design_system.Typography

@Composable
fun HeaderUnit(
    amount: Int,
    unit: String,
    amountTextSize: TextUnit = 20.sp,
    amountTextColor: Color = MaterialTheme.colorScheme.onPrimary,
    unitTextSize: TextUnit = 14.sp,
    unitTextColor: Color = MaterialTheme.colorScheme.onPrimary,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = amount.toString(),
            color = amountTextColor,
            fontSize = amountTextSize,
            fontWeight = FontWeight.Medium,
            style = Typography.headlineLarge,
            modifier = Modifier.alignByBaseline()
        )
        Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
        Text(
            text = unit,
            color = unitTextColor,
            fontSize = unitTextSize,
            fontWeight = FontWeight.Normal,
            style = Typography.bodyLarge,
            modifier = Modifier.alignByBaseline()
        )
    }
}

@Preview
@Composable
private fun HeadUnitPreview() {
    CalorifyTheme {
        HeaderUnit(amount = 100, unit = "kcal")
    }
}