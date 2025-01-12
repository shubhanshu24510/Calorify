package com.shubhans.tracker.presentation.tracker_Overview.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing

@Composable
fun AddMealFood(
    text: String,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(100f)
            )
            .padding(spacing.spaceMedium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = color
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = color,
            modifier = Modifier.padding(start = spacing.spaceSmall)
        )
    }
}

@Preview
@Composable
private fun AddButtonPreview() {
    CalorifyTheme {
        AddMealFood(text = "Add Breakfast", onClick = {})
    }
}