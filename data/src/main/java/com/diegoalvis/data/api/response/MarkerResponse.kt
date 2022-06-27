package com.diegoalvis.data.api.response

import com.diegoalvis.core.entities.MarkerEntity

internal data class MarkerResponse(
    val lat: Double,
    val lng: Double,
)

internal fun MarkerResponse.toEntity() =
    MarkerEntity(
        lat = lat,
        lng = lng,
    )