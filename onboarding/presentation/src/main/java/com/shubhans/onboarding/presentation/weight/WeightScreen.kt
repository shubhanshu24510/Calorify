package com.shubhans.onboarding.presentation.weight

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun WeightScreen(
    viewModel: WeightViewModel = koinViewModel(),
    onNextClick: () -> Unit = {}
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                is UiEvent.showSnackbarMessage -> {
                    snackBarHostState.showSnackbar(
                        message = event.message.asString(context),
                    )
                }
                else -> {}
            }
        }
    }
    val spacing = LocalSpacing.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(spacing.spaceLarge)
            .padding(vertical = spacing.spaceLargeVertical),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.your_weight),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.weight,
                onValueChange =viewModel::onWeightEnter,
                unit = stringResource(R.string.kg)
            )
        }
        ActionButton(
            text = stringResource(R.string.next),
            onClick = viewModel::OnNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun WeightScreenPreview() {
    CalorifyTheme {
        WeightScreen()
    }
}