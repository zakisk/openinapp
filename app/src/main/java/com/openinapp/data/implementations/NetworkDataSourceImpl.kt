package com.openinapp.data.implementations

import android.util.Log
import com.openinapp.data.services.NetworkService
import com.openinapp.domain.interfaces.NetworkDataSource
import com.openinapp.domain.models.DashboardData
import retrofit2.HttpException
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val networkService: NetworkService
) : NetworkDataSource {
    override suspend fun getDashboardData(): DashboardData {
        return try {
            networkService.getDashboardData()
        } catch (e: Exception) {
            DashboardData(message = e.localizedMessage)
        }
    }

}