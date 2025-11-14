package com.safiribytes.dashboard.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safiribytes.core.utils.UiEvents
import com.safiribytes.dashboard.domain.repositories.HomeRepository
import com.safiribytes.dashboard.presentation.HomeUIEvents
import com.safiribytes.dashboard.presentation.HomeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {
    val TAG = "HomeViewModel"

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvents = Channel<UiEvents>(Channel.UNLIMITED)
    val uiEvents = _uiEvents.receiveAsFlow()

    fun fetchHomeData() {
        updateIsLoading(value = true)

        viewModelScope.launch {
            homeRepository.fetchHomeData()
                .catch { error ->
                    updateIsLoading(value = false)
                    _uiEvents.trySend(
                        UiEvents.SnackBarEvent("Failed to fetch home data.")
                    )
                }
                .collect{ data ->
                    updateIsLoading(value = false)
                    _uiState.update {
                        it.copy(
                            homeResponseModel = data
                        )
                    }
                }
        }
    }

    fun updateIsLoading(value: Boolean){
        _uiState.update {
            it.copy(
                isLoading = value
            )
        }
    }


    fun updateMessage(value: String){
        _uiState.update {
            it.copy(
                message = value
            )
        }
    }

    fun onEvent(event: HomeUIEvents){
        when(event){
            HomeUIEvents.OnNavigateUp -> {

            }
        }
    }

}