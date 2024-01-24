package com.openinapp.domain.interfaces

import com.openinapp.domain.models.DashboardData

interface NetworkDataSource {
    suspend fun getDashboardData() : DashboardData
}