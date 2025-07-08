package com.example.caffeine

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class CoffeeSize {
    SMALL, MEDIUM, LARGE
}

enum class CoffeeStrength {
    LOW, MEDIUM, HIGH
}

data class CoffeeOrderState(
    val selectedSize: CoffeeSize = CoffeeSize.SMALL,
    val selectedStrength: CoffeeStrength = CoffeeStrength.LOW
)

class CoffeeOrderViewModel : ViewModel() {
    private val _orderState = MutableStateFlow(CoffeeOrderState())
    val orderState: StateFlow<CoffeeOrderState> = _orderState.asStateFlow()

    fun selectSize(size: CoffeeSize) {
        _orderState.value = _orderState.value.copy(selectedSize = size)
    }

    fun selectStrength(strength: CoffeeStrength) {
        _orderState.value = _orderState.value.copy(selectedStrength = strength)
    }

    fun onContinueClicked() {
        // Handle continue action
        // This would typically navigate to the next screen or submit the order
    }
}
