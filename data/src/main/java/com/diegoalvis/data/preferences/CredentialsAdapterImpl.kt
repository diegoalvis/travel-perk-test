package com.diegoalvis.data.preferences

import com.diegoalvis.core.entities.UserCredentialsEntity
import com.diegoalvis.core.interfaces.CredentialsAdapter

class CredentialsAdapterImpl: CredentialsAdapter {
    override fun getUserCredentials(): UserCredentialsEntity {
        // TOD extract from preferneces or db
        return UserCredentialsEntity(
            clientId = "SFTEX4E45MNUAZXMABQOF4NVEBEIOYKE53ZNMIP40RX2S4CK",
            clientSecret = "5AGNN0IDYHURCDITIZX1PAGMFHEO4O0I4VEBLPKMJEPTQPH4"
        )
    }
}