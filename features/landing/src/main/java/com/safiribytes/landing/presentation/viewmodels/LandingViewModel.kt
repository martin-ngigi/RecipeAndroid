package com.safiribytes.landing.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.safiribytes.landing.presentation.LandingUIEvents
import com.safiribytes.landing.presentation.LandingUIStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(LandingUIStates())
    val uiState = _uiState.asStateFlow()

    private val _uiEvents = Channel<LandingUIEvents>(Channel.UNLIMITED)
    val uiEvent = _uiEvents.receiveAsFlow()

    fun onEvent(event: LandingUIEvents){
        when (event){
            LandingUIEvents.OnExit -> {

            }
            LandingUIEvents.OnTapGetStarted -> {

            }
        }
    }

}