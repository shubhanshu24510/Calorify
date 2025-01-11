package com.shubhans.tracker.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.shubhans.tracker.presentation.components.DaySelector
import com.shubhans.tracker.presentation.components.TrackerHeader
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun TrackerScreen(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TrackerHeader()
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            DaySelector(
                date = LocalDate.now(),
                onNextDayClick = {},
                onPreviousDayClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium),
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TrackerScreenPreview() {
    CalorifyTheme {
        TrackerScreen()
    }
}