package com.shubhans.core.presentation.utils

sealed class UiEvent {
    object Success : UiEvent()
    object OnNavigateUp : UiEvent()
    data class showSnackbarMessage(val message: UiText) : UiEvent()
}