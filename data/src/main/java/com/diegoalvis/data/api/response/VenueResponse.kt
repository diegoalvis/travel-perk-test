package com.diegoalvis.data.api.response

import com.diegoalvis.core.entities.VenueEntity

data class Response<T>(
    val response: T
)

data class VenueListResponse(
    val venues: List<VenueResponse>
)

data class VenueResponse(
    val name: String,
    val location: LocationResponse,
)


fun VenueResponse.toEntity() =
    VenueEntity(
        name = name,
        address = location.address,
        lat = location.lat,
        lng = location.lng,
    )