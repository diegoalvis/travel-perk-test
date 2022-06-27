package com.diegoalvis.travelperktest._di

import com.diegoalvis.core.usecases.GetMarkersUseCase
import com.diegoalvis.core.usecases.GetVenuesUseCase
import com.diegoalvis.travelperktest.ui.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // View Models
    viewModel { MapsViewModel(getVenuesUseCase = get()) }

    // Use Cases
    factory {
        GetMarkersUseCase(service = get(), localDataSource = get())
    }
    factory {
        GetVenuesUseCase(venueServiceAdapter = get(), credentialsAdapter = get() )
    }
}