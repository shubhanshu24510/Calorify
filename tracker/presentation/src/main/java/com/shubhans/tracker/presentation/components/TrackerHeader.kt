package com.shubhans.tracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.core.presentation.design_system.Typography
import com.shubhans.tracker.presentation.R

@Composable
fun TrackerHeader(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(400.dp)
            .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(spacing.spaceLarge)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeaderUnit(
                amount = 0,
                unit = "kcal",
                amountTextSize = 40.sp,
                unitTextColor = MaterialTheme.colorScheme.onBackground,
                amountTextColor = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(alignment = Alignment.Bottom)
            )
            Column {
                Text(
                    text = stringResource(id = R.string.your_goal),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = Typography.bodyMedium,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
                HeaderUnit(
                    amount = 2465,
                    unit = "kcal",
                    amountTextSize = 40.sp,
                    unitTextColor = MaterialTheme.colorScheme.onBackground,
                    amountTextColor = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        HeaderBar(
            modifier = Modifier.fillMaxWidth()
                .heightIn(30.dp),
            carbsRatio = 10,
            proteinsRatio = 60,
            fatsRatio = 30,
            calories = 300,
            caloriesGoal = 2365,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TrackerHeaderPreview() {
    CalorifyTheme {
        TrackerHeader()
    }
}