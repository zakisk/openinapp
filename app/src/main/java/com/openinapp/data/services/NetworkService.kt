package com.openinapp.data.services

import com.openinapp.domain.models.DashboardData
import retrofit2.http.GET

interface NetworkService {

    @GET("/api/v1/dashboardNew")
    suspend fun getDashboardData(): DashboardData
}