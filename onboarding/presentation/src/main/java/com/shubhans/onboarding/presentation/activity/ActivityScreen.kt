package com.shubhans.onboarding.presentation.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shubhans.core.presentation.design_system.CalorifyTheme
import com.shubhans.core.presentation.design_system.LocalSpacing
import com.shubhans.core.presentation.utils.UiEvent
import com.shubhans.domain.model.ActivityLevel
import com.shubhans.onboarding.presentation.R
import com.shubhans.onboarding.presentation.components.ActionButton
import com.shubhans.onboarding.presentation.components.SelectableButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActivityScreen(
    viewModel: ActivityViewModel = koinViewModel(),
    onNextClick: () -> Unit = {}
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Success -> onNextClick()
                else -> Unit
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
                text = stringResource(R.string.activity_level),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(spacing.spaceMedium))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium)
            ) {
                SelectableButton(
                    text = stringResource(R.string.low),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Low,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelected(ActivityLevel.Low)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                SelectableButton(
                    text = stringResource(R.string.medium),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelected(ActivityLevel.Medium)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                SelectableButton(
                    text = stringResource(R.string.high),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.High,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelected(ActivityLevel.High)
                    },
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(R.string.next),
            onClick = viewModel::OnNextClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ActivityScreenPreview() {
    CalorifyTheme {
        ActivityScreen()
    }
}