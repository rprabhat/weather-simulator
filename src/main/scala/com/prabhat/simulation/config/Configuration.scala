package com.prabhat.simulation.config

import com.typesafe.config.ConfigFactory

/**
  * Created by prabhat on 23/08/2016.
  */

case class MinMax[T](max: T, min : T)
case class LatitudeConfig(minMax: MinMax[Double])
case class LongitudeConfig(minMax: MinMax[Double])
case class ElevationConfig(minMax: MinMax[Int])
case class TemperatureConfig(monthTemp : Map[Int , (MinMax[Double])])
case class PressureConfig(minMax: MinMax[Double])
case class HumidityConfig(minMax: MinMax[Int])
case class YearConfig(minMax: MinMax[Int])
case class MonthConfig(minMax: MinMax[Int])
case class DaayConfig(minMax: MinMax[Int])
case class HourConfig(minMax: MinMax[Int])
case class MinuteConfig(minMax: MinMax[Int])
case class SecConfig(minMax: MinMax[Int])


object Configuration {

  val configuration = ConfigFactory.load().getConfig("weatherConfig")

  val latitudeConfig = {
    val config = configuration.getConfig("latitude")
    LatitudeConfig(
      MinMax[Double](config.getDouble("max"),
      config.getDouble("min"))
    )
  }

  val longitudeConfig = {
    val config = configuration.getConfig("longitude")
    LongitudeConfig(
      MinMax(config.getDouble("max"),
      config.getDouble("min"))
    )
  }

  val elevationConfig = {
    val config = configuration.getConfig("elevation")
    ElevationConfig(
      MinMax( config.getInt("max"),
      config.getInt("min"))
    )
  }

//  val TemperatureConfig = {
//    val list : Iterable[ConfigObject] = configuration.getObjectList("temperatures").asScala
//    (for {item: ConfigObject <- list
//         entry: Entry[Int, ConfigValue] <- item.entrySet().asScala
//         month = entry.getKey
//         temp: ConfigObject = entry.getValue.unwrapped()
//         minmax = MinMax(temp.toConfig.getDouble("max"),
//           temp.toConfig.getDouble("min"))
//    } yield (month, minmax)).toMap
//  }

  //TODO read from config
  val TemperatureConfig: Map[Int, (Double, Double)] = Map(
    1 -> (-5.0,25.0),
    2 -> (-4.0,30.6),
    3 -> (-3.0,34.0),
    4 -> (-2.0,37.5),
    5 -> (-2.0,38.2),
    6 -> (-1.0,51.3),
    7 -> (-7.0,37.1),
    8 -> (-10.0,33.4),
    9 -> (-15.1,27.5),
    10 -> (-20.2,25.7),
    11 -> (-30.1,20.8),
    12 -> (-35.1,17.9)
  )


  val pressureConfig = {
    val config = configuration.getConfig("pressure")
    PressureConfig(
      MinMax( config.getDouble("max"),
        config.getDouble("min"))
    )
  }

  val humidityConfig = {
    val config = configuration.getConfig("humidity")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }

  val yearConfig = {
    val config = configuration.getConfig("year")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
  val monthConfig = {
    val config = configuration.getConfig("month")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
  val dayConfig = {
    val config = configuration.getConfig("day")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
  val hourConfig = {
    val config = configuration.getConfig("hour")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
  val minuteConfig = {
    val config = configuration.getConfig("minute")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
  val secondConfig = {
    val config = configuration.getConfig("sec")
    HumidityConfig(
      MinMax( config.getInt("max"),
        config.getInt("min"))
    )
  }
}
