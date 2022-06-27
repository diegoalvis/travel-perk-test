package com.diegoalvis.travelperktest.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.diegoalvis.travelperktest.R
import com.diegoalvis.travelperktest.databinding.ActivityMapsBinding
import com.diegoalvis.travelperktest.ui.models.MapUiModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val viewModel: MapsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        viewModel.uiModel.observe(this, ::handleUiData)
        viewModel.loadVenues()
    }

    private fun handleUiData(mapUiModel: MapUiModel) {
        when (mapUiModel) {
            is MapUiModel.Failure -> {
                binding.progress.isVisible = false
                Toast.makeText(this, mapUiModel.error, Toast.LENGTH_LONG).show()
            }
            MapUiModel.Initial -> binding.progress.isVisible = false

            MapUiModel.Loading -> {
                binding.progress.isVisible = true
            }
            is MapUiModel.Success -> {
                binding.progress.isVisible = false
                mapUiModel.venues.forEach { venue ->
                    mMap.addMarker(
                        MarkerOptions()
                            .position(venue.latLng)
                            .title(venue.name)
                            .snippet(venue.address)
                    )
                }

                mapUiModel.venues.firstOrNull()?.let {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it.latLng, 16f))
                }
            }
        }
    }
}