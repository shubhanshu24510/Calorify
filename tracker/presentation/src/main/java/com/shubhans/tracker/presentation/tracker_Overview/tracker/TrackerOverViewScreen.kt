package com.shubhans.tracker.presentation.tracker_Overview.tracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.tracker.presentation.R
import com.shubhans.tracker.presentation.components.NutrientInfo
import com.shubhans.tracker.presentation.tracker_Overview.components.AddMealFood
import com.shubhans.tracker.presentation.tracker_Overview.components.DaySelector
import com.shubhans.tracker.presentation.tracker_Overview.components.ExpandableMeal
import com.shubhans.tracker.presentation.tracker_Overview.components.TrackedFoodItem
import com.shubhans.tracker.presentation.tracker_Overview.components.TrackerHeader
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun TrackerScreen(
    modifier: Modifier = Modifier,
    viewModel: TrackerOverviewViewModel = koinViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(bottom = spacing.spaceLarge),
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
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))
        }
        items(state.meals) { meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {
                    viewModel.onAction(TrackerOverviewAction.onMealToggleClick(meal))
                },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                    ) {
                        state.trackedFood.forEach { trackedFood ->
                            TrackedFoodItem(
                                trackedFood = trackedFood,
                                onDeleteClick = {
                                    viewModel.onAction(
                                        TrackerOverviewAction.onTrackedFoodDeleteClick(trackedFood)
                                    )
                                },
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        }
                        AddMealFood(
                            text = stringResource(
                                id = R.string.add_food,
                                meal.name.asString(context)
                            ),
                            onClick = {},
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
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