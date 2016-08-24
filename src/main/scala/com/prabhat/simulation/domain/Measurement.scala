package com.prabhat.simulation.domain

/**
  * Created by prabhat on 23/08/2016.
  */
trait Measurement[T] {
  def value : T
}

trait AtmosphereMeasurement[T] extends Measurement[T]

case class Temperature(value : Double) extends AtmosphereMeasurement[Double]
case class Pressure(value : Double) extends AtmosphereMeasurement[Double]
case class Humidity(value : Int) extends AtmosphereMeasurement[Int]


trait LocationMeasurement[T] extends Measurement[T]


case class Latitude(value : Double ) extends LocationMeasurement[Double]
case class Longitude(value : Double ) extends LocationMeasurement[Double]
case class Elevation(value : Int ) extends LocationMeasurement[Int]
