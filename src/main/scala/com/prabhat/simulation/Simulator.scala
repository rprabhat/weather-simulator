package com.prabhat.simulation

import com.prabhat.simulation.config.{MinMax, Configuration}
import com.prabhat.simulation.domain._
import com.prabhat.simulation.util.Gen

/**
  * Created by prabhat on 21/08/2016.
  */

object Simulator extends App {

  val genLabel : Gen[Label] = Gen.listOfN(10, Gen.alphaLowerChar).map(name => Label(Option(name.mkString)))

  val genPosition: Gen[Position] = for {
    lat <- Gen.choose(Configuration.latitudeConfig.minMax).map(Latitude)
    long <- Gen.choose(Configuration.longitudeConfig.minMax).map(Longitude)
    elev <- Gen.chooseInt(Configuration.elevationConfig.minMax).map(Elevation)
  } yield Position(long, lat, elev)

  val genTimestamp = for {
    year <- Gen.chooseInt(Configuration.yearConfig.minMax).map(Year)
    month <- Gen.chooseInt(Configuration.monthConfig.minMax).map(Month)
    day <- Gen.chooseInt(Configuration.dayConfig.minMax).map(Day)
    hour <- Gen.chooseInt(Configuration.hourConfig.minMax).map(Hour)
    min <- Gen.chooseInt(Configuration.minuteConfig.minMax).map(Minute)
    sec <- Gen.chooseInt(Configuration.secondConfig.minMax).map(Sec)
  } yield LocalTime(year, month, day, hour, min, sec)

  def genAtmosphere(month : Int) = for {
    temperature <- {
      val monthMinMax = Configuration.TemperatureConfig.get(month).map(a => MinMax[Double](a._1, a._2)).get
      Gen.choose(monthMinMax).map(Temperature)
    }
    humidity <- Gen.chooseInt(Configuration.humidityConfig.minMax).map(Humidity)
    pressure <- Gen.choose(Configuration.pressureConfig.minMax).map(Pressure)
  } yield Atmosphere(temperature, pressure, humidity)

  def genCondition(atmosphere: Atmosphere) = Gen.const[Condition](Condition(atmosphere))



  val genWeatherData = for {
    label <- genLabel
    position <- genPosition
    localTime <- genTimestamp
    atmosphere <- genAtmosphere(localTime.month.value)
    condition <- genCondition(atmosphere)
  } yield WeatherData(label, position,localTime , condition, atmosphere)

  Gen.generate(10)(genWeatherData).foreach(println)
}