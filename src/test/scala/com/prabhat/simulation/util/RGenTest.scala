package com.prabhat.simulation.util

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.matchers.Matcher

import scala.util.Random

/**
  * Created by prabhat on 24/08/2016.
  */
class RGenTest extends FlatSpec with Matchers {

  "Range generator" should "generate value within range" in {
    val result = RGen.betweenInt(10, 20)(RGen(Random))
    result._1 should be  >= 10
    result._1 should be  <= 20
  }

  "Nonnegative generator" should "generate negative number" in {
    val result = RGen.nonNegativeInt(RGen(Random))
    result._1 should be  >= 0
  }

  "Char generator" should "generate printable character" in {
    val result = RGen.char(RGen(Random))
    result._1.toInt should be  >= 33
    result._1.toInt should be  <= 126
  }
}
