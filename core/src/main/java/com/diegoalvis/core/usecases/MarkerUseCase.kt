package com.diegoalvis.core.usecases

import com.diegoalvis.core.entities.MarkerEntity
import com.diegoalvis.core.interfaces.MarkerDaoAdapter
import com.diegoalvis.core.interfaces.MarkerServiceAdapter
import java.util.concurrent.TimeoutException

class GetMarkersUseCase(
    private val service: MarkerServiceAdapter,
    private val localDataSource: MarkerDaoAdapter,
) : BaseUseCase<NoParams, List<MarkerEntity>>() {

    override suspend fun execute(input: NoParams): Result<List<MarkerEntity>> {
        return runCatching {
            val response = service.getMarkerList()
            localDataSource.saveMarkers(response)
            response
        }.recoverCatching { exception ->
            when (exception) {
                is TimeoutException -> localDataSource.getMarkerList()
                else -> throw exception
            }
        }
    }

}