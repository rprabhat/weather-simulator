package com.prabhat.simulation.domain

/**
  * Created by prabhat on 23/08/2016.
  */
case class Label(value: Option[String]) {
  override  def toString = value match {
    case Some(v) => v
    case None => ""
  }
}


//TODO  timestamp validation
case class Year(value : Int)
case class Month(value : Int)
case class Day(value : Int)
case class Hour(value: Int)
case class Minute(value: Int)
case class Sec(value: Int)
case class LocalTime(year: Year, month: Month, day: Day, hour: Hour, min: Minute, sec: Sec){
  override  def toString = f"${year.value}-${month.value}%02d-${day.value}%02d ${hour.value}%02d:${min.value}%02d:${sec.value}%02d"
}


case class WeatherData(label: Label,
                       position: Position,
                       localTime: LocalTime,
                       condition: Condition,
                       atmosphere: Atmosphere)
{
  override  def toString = s"$label|$position|$localTime|$condition|$atmosphere"
}


