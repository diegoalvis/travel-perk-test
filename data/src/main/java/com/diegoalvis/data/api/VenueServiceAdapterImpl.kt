package com.diegoalvis.data.api

import com.diegoalvis.core.entities.VenueEntity
import com.diegoalvis.core.interfaces.VenueServiceAdapter
import com.diegoalvis.data.api.response.VenueResponse
import com.diegoalvis.data.api.response.toEntity
import com.diegoalvis.data.api.service.VenueService

class VenueServiceAdapterImpl(
    private val venueService: VenueService,
): VenueServiceAdapter {

    override suspend fun getVenues(clientId: String, clientSecret: String, lat: Double, lng: Double): List<VenueEntity> {
        val latLng = listOf(lat, lng).joinToString(",")
        try {
            val response = venueService.getVenues(clientId = clientId, clientSecret = clientSecret, latLng = latLng).response
            val venues = response.venues.map(VenueResponse::toEntity)
            return venues
        } catch (e: Exception) {
            // TODO handle exceptions
            e.printStackTrace()
            throw e
        }
    }


}