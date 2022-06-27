package com.diegoalvis.travelperktest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoalvis.core.usecases.GetVenuesUseCase
import com.diegoalvis.core.usecases.VenueParams
import com.diegoalvis.travelperktest.ui.models.MapUiModel
import com.diegoalvis.travelperktest.ui.models.VenueUiModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MapsViewModel(
    private val getVenuesUseCase: GetVenuesUseCase,
) : ViewModel() {

    private val _uiModel = MutableLiveData<MapUiModel>(MapUiModel.Initial)
    val uiModel: LiveData<MapUiModel>
        get() = _uiModel


    fun loadVenues() {
        viewModelScope.launch {
            _uiModel.value = MapUiModel.Loading
            val params = VenueParams(lat = 41.3850371, lng = 2.1767156)
            with(Dispatchers.IO) {
                val venues = getVenuesUseCase.execute(params)
                    .fold(
                        onSuccess = { venues ->
                            _uiModel.postValue(
                                MapUiModel.Success(
                                    venues = venues.map {
                                        VenueUiModel(
                                            name = it.name,
                                            address = it.address,
                                            latLng = LatLng(it.lat, it.lng)
                                        )
                                    }
                                )
                            )
                        },
                        onFailure = {
                            _uiModel.postValue(MapUiModel.Failure("Something went wrong"))
                        }
                    )
            }
        }
    }

}

