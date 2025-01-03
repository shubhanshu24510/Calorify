package com.shubhans.onboarding.presentation.nutrient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.onboarding.presentation.R
import com.shubhans.onboarding.presentation.components.ActionButton
import com.shubhans.onboarding.presentation.components.UnitTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun NutrientGoalScreen(
    viewModel: NutrientViewModel = koinViewModel(), onNextClick: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                is UiEvent.showSnackbarMessage -> {
                    snackBarHostState.showSnackbar(
                        message = event.message.length.toString()
                    )
                }

                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.nutrient_goals),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))

            UnitTextField(
                value = viewModel.state.carbonValue, onValueChange = {
                    viewModel.onAction(action = NutrientGoalAction.enterCarbonRatio(it))
                },
                unit = stringResource(R.string.carbs)
            )
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))

            UnitTextField(
                value = viewModel.state.proteinsValue, onValueChange = {
                    viewModel.onAction(action = NutrientGoalAction.enterProteinRatio(it))

                },
                unit = stringResource(R.string.proteins)
            )
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))

            UnitTextField(
                value = viewModel.state.fatsValue, onValueChange = {
                    viewModel.onAction(action = NutrientGoalAction.enterFatRatio(it))
                },
                unit = stringResource(R.string.fats)
            )
        }
        ActionButton(
            text = stringResource(R.string.next),
            onClick = { viewModel.onAction(NutrientGoalAction.OnNextClick) },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NutrientGoalPreview() {
    CalorifyTheme {
        NutrientGoalScreen()
    }
}