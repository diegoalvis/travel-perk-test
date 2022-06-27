package com.diegoalvis.core.usecases

import com.diegoalvis.core.entities.VenueEntity
import com.diegoalvis.core.interfaces.CredentialsAdapter
import com.diegoalvis.core.interfaces.VenueServiceAdapter

class GetVenuesUseCase(
    private val venueServiceAdapter: VenueServiceAdapter,
    private val credentialsAdapter: CredentialsAdapter,
): BaseUseCase<VenueParams, List<VenueEntity>>() {


    override suspend fun execute(input: VenueParams): Result<List<VenueEntity>> {
        return kotlin.runCatching {
            val userCredentials = credentialsAdapter.getUserCredentials()


            venueServiceAdapter.getVenues(
                clientId = userCredentials.clientId,
                clientSecret = userCredentials.clientSecret,
                lat = input.lat,
                lng = input.lng,
            )
        }
    }
}


 class VenueParams(
     val lat: Double,
     val lng: Double,
 )