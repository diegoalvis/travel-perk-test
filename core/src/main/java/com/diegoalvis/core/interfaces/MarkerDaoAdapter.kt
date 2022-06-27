package com.diegoalvis.core.interfaces

import com.diegoalvis.core.entities.MarkerEntity

interface MarkerDaoAdapter {

    suspend fun saveMarkers(markers: List<MarkerEntity>)

    suspend fun getMarkerList(): List<MarkerEntity>

}