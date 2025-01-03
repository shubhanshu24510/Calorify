package com.shubhans.domain.usecases

class FitterOutDigit {
    operator fun invoke(input: String): String {
        return input.filter { it.isDigit() }
    }
}