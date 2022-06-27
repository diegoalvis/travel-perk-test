package com.diegoalvis.core.interfaces

import com.diegoalvis.core.entities.VenueEntity

interface VenueServiceAdapter {

    suspend fun getVenues(
        clientId: String,
        clientSecret: String,
        lat: Double,
        lng: Double
    ): List<VenueEntity>
}