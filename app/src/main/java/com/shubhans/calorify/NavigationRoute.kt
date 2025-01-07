package com.shubhans.calorify

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.shubhans.onboarding.presentation.activity.ActivityScreen
import com.shubhans.onboarding.presentation.age.AgeScreen
import com.shubhans.onboarding.presentation.gender.GenderScreen
import com.shubhans.onboarding.presentation.goal.GoalScreen
import com.shubhans.onboarding.presentation.height.HeightScreen
import com.shubhans.onboarding.presentation.nutrient.NutrientGoalScreen
import com.shubhans.onboarding.presentation.weight.WeightScreen
import com.shubhans.onboarding.presentation.welcome.WelcomeScreen
import com.shubhans.tracker.presentation.TrackerScreen

@Composable
fun NavigationRoute(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "onBoarding"
    ) {
        onBoardingGraph(navController = navController)
        trackerGraph(navController = navController)
    }
}

private fun NavGraphBuilder.onBoardingGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "welcome", route = "onBoarding"
    ) {
        composable(route = "welcome") {
            WelcomeScreen(
                onNextClick = {
                    navController.navigate("gender")
                }
            )
        }
        composable(route = "gender") {
            GenderScreen(
                onNextClick = {
                    navController.navigate("age")

                }
            )
        }
        composable(route = "age") {
            AgeScreen(
                onNextClick = {
                    navController.navigate("height")
                }
            )
        }
        composable(route = "height") {
            HeightScreen(
                onNextClick = {
                    navController.navigate("weight")
                }
            )
        }
        composable(route = "weight") {
            WeightScreen(
                onNextClick = {
                    navController.navigate("activityLevel")
                }
            )
        }
        composable(route = "activityLevel") {
            ActivityScreen(
                onNextClick = {
                    navController.navigate("goalLevel")
                }
            )
        }
        composable(route = "activityLevel") {
            ActivityScreen(
                onNextClick = {
                    navController.navigate("goalLevel")
                }
            )
        }
        composable(route = "goalLevel") {
            GoalScreen(
                onNextClick = {
                    navController.navigate("nutrition")
                }
            )
        }
        composable(route = "nutrition") {
            NutrientGoalScreen(
                onNextClick = {
                    navController.navigate("tracker")
                }
            )
        }
    }
}

private fun NavGraphBuilder.trackerGraph(
    navController: NavController
) {
    navigation(
        startDestination = "trackerHome", route = "tracker"
    ) {
        composable(route = "trackerHome") {
            TrackerScreen()
        }
    }
}