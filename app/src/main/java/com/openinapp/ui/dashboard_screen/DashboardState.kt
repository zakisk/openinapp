package com.openinapp.ui.dashboard_screen

import com.openinapp.domain.models.DashboardData

data class DashboardState(
    val isLoading : Boolean = false,
    val dashboardData: DashboardData? = null,
    val error : String? = null
)
