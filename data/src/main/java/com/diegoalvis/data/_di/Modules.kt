package com.diegoalvis.data._di

import com.diegoalvis.core.interfaces.CredentialsAdapter
import com.diegoalvis.core.interfaces.VenueServiceAdapter
import com.diegoalvis.data.api.VenueServiceAdapterImpl
import com.diegoalvis.data.api.service.VenueService
import com.diegoalvis.data.network.createRetrofit
import com.diegoalvis.data.preferences.CredentialsAdapterImpl
import org.koin.dsl.module

val dataModule = module {

    single {
        val baseUrl = "https://api.foursquare.com/"
        createRetrofit(baseUrl).create(VenueService::class.java)
    }

    single<VenueServiceAdapter> {
        VenueServiceAdapterImpl(venueService = get())
    }

    single<CredentialsAdapter> {
        CredentialsAdapterImpl()
    }


}