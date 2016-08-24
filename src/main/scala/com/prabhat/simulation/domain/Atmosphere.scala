package com.prabhat.simulation.domain

/**
  * Created by prabhat on 23/08/2016.
  */
case class Atmosphere(temperature: Temperature, pressure: Pressure, humidity: Humidity){
  override  def toString = f"${temperature.value}%+1.2f|${pressure.value}%1.2f|${humidity.value}"
}
