package com.diegoalvis.core.interfaces

import com.diegoalvis.core.entities.MarkerEntity

interface MarkerServiceAdapter {

    suspend fun getMarkerList(): List<MarkerEntity>

}