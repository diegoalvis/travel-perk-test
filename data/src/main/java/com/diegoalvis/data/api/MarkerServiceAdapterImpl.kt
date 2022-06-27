package com.diegoalvis.data.api

import com.diegoalvis.core.entities.MarkerEntity
import com.diegoalvis.core.interfaces.MarkerServiceAdapter
import com.diegoalvis.data.api.response.MarkerResponse
import com.diegoalvis.data.api.response.toEntity
import com.diegoalvis.data.api.service.MarkerService

internal class MarkerServiceAdapterImpl(
     private val service: MarkerService,
) : MarkerServiceAdapter {

    override suspend fun getMarkerList(): List<MarkerEntity> {
        return service.getMarkers().map(MarkerResponse::toEntity)
    }

    companion object {
        const val MARKER_BASE_RUL = "https://mocki.io"
    }
}
