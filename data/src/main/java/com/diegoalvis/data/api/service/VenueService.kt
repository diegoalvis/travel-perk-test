package com.diegoalvis.data.api.service

import com.diegoalvis.data.api.response.Response
import com.diegoalvis.data.api.response.VenueListResponse
import com.diegoalvis.data.api.response.VenueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueService {

    @GET("/v2/venues/search")
    suspend fun getVenues(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("ll") latLng: String,
        @Query("v") version: String = "20190717",
    ): Response<VenueListResponse>

}


