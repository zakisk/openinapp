package com.openinapp.domain.use_cases

import com.openinapp.domain.interfaces.NetworkDataSource
import com.openinapp.domain.models.DashboardData
import com.openinapp.domain.models.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDashboardDataUseCase @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {
    operator fun invoke(): Flow<DataState<DashboardData>> = flow {
        emit(DataState.Loading<Nothing>())
        val data = networkDataSource.getDashboardData()
        emit(DataState.Success(data = data))
    }
}