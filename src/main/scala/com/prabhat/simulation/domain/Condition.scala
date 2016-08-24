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

case object Snow extends Condition
case object Sunny extends Condition
case object Rain extends Condition
