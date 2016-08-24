package com.prabhat.simulation.domain

/**
  * Created by prabhat on 23/08/2016.
  */
case class Position(longitude: Longitude, latitude: Latitude, elevation: Elevation) {
  override  def toString = f"${longitude.value}%1.2f,${latitude.value}%1.2f,${elevation.value}"
}
