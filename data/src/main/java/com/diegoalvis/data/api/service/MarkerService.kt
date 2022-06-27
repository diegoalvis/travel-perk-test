package com.diegoalvis.data.api.service

import com.diegoalvis.data.api.response.MarkerResponse
import retrofit2.http.GET

internal interface MarkerService {

    @GET("v1/2dbc26fc-05fe-4e88-9e8a-a270a9174cb8")
    suspend fun getMarkers(): List<MarkerResponse>
}