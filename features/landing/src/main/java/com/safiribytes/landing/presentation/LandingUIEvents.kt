package com.safiribytes.landing.presentation

sealed interface LandingUIEvents{
    data object OnTapGetStarted: LandingUIEvents
    data object OnExit: LandingUIEvents
}