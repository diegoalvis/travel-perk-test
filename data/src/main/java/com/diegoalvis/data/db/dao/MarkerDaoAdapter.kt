package com.diegoalvis.data.db.dao

import com.diegoalvis.core.entities.MarkerEntity
import com.diegoalvis.core.interfaces.MarkerDaoAdapter
import com.diegoalvis.data.db.models.MarkerModel
import com.diegoalvis.data.db.models.toEntity
import com.diegoalvis.data.db.models.toModel

internal class MarkerDaoAdapterImpl(
    private val dao: MarkerDao
) : MarkerDaoAdapter {

    override suspend fun saveMarkers(markers: List<MarkerEntity>) {
        markers.map(MarkerEntity::toModel).forEach {
            dao.insertMarker(it)
        }
    }

    override suspend fun getMarkerList(): List<MarkerEntity> {
        return dao.getMarkers().map(MarkerModel::toEntity)
    }
}