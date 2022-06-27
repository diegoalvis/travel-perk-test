package com.diegoalvis.travelperktest.ui.models

import com.google.android.gms.maps.model.LatLng


sealed class MapUiModel {
    object Initial: MapUiModel()
    class Success(
        val venues: List<VenueUiModel>
    ) : MapUiModel()
    object Loading : MapUiModel()
    class Failure(val error: String) : MapUiModel()
}


data class VenueUiModel(
    val name: String,
    val address: String?,
    val latLng: LatLng,
)

