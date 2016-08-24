package com.prabhat.simulation.domain

/**
  * Created by prabhat on 23/08/2016.
  */
sealed trait Condition{
  override  def toString = this match {
    case Snow => "Snow"
    case Rain => "Rain"
    case Sunny => "Sunny"
  }
}

object Condition {
  def apply (atmosphere: Atmosphere) = {
    (atmosphere.temperature, atmosphere.humidity, atmosphere.pressure) match {
      case (t,h,m) if h.value > 80  => Rain
      case (t,h,m) if t.value >= -25 && t.value <= 2  => Snow
      case _ => Sunny
    }
  }
}

case object Snow extends Condition
case object Sunny extends Condition
case object Rain extends Condition
