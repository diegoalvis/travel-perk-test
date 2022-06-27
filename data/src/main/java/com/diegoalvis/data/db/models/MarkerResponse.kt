package com.diegoalvis.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegoalvis.core.entities.MarkerEntity

@Entity
internal data class MarkerModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val lat: Double,
    val lng: Double,
)


internal fun MarkerEntity.toModel() =
    MarkerModel(
        lat = lat,
        lng = lng,
    )

internal fun MarkerModel.toEntity() =
    MarkerEntity(
        lat = lat,
        lng = lng,
    )