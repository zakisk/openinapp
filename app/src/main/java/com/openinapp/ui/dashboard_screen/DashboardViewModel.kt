package com.openinapp.ui.dashboard_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openinapp.domain.models.DataState
import com.openinapp.domain.use_cases.GetDashboardDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDashboardDataUseCase: GetDashboardDataUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state: MutableState<DashboardState> = mutableStateOf(DashboardState())
    val state: State<DashboardState> = _state

    init {
        getDashboardData()
    }

    private fun getDashboardData() {
        getDashboardDataUseCase().onEach {
            when (it) {
                is DataState.Loading -> {
                    _state.value = DashboardState(isLoading = true)
                }

                is DataState.Success -> {
                    if (it.data?.status == true) {
                        _state.value = DashboardState(dashboardData = it.data)
                    } else {
                        _state.value = DashboardState(error = it.message ?: "Unknown Error")
                    }
                }

                is DataState.Error -> {
                    _state.value = DashboardState(error = it.message ?: "Unknown Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}