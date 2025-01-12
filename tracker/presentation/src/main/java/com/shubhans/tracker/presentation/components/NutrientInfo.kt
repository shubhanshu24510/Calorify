package com.shubhans.tracker.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NutrientInfo(
    name: String,
    amount: Int,
    unit: String,
    nameTextStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    amountTextSize: TextUnit = 20.sp,
    amountTextColor: Color = Color.White,
    unitTextColor: Color = Color.White,
    unitTextSize: TextUnit = 14.sp,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderUnit(
            amount = amount,
            unit = unit,
            amountTextSize = amountTextSize,
            unitTextSize = unitTextSize,
            amountTextColor = amountTextColor,
            unitTextColor = unitTextColor,
        )
        Text(
            text = name,
            color = Color.White,
            style = nameTextStyle,
            fontWeight = FontWeight.Light
        )
    }
}