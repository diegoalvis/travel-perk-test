package com.diegoalvis.core.entities

data class VenueEntity(
  val name: String,
  val address: String?,
  val lat: Double,
  val lng: Double,
)