package com.prabhat.simulation.generator

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.matchers._

/**
  * Created by prabhat on 24/08/2016.
  */
class GenTest extends FlatSpec with Matchers {

  "Const generator" should "generate given value" in {
    Gen.generate(1)(Gen.const("TEST")) shouldEqual  "TEST" :: Nil
  }

  "list generator " should "generate provided number of random values" in {
    Gen.generate(1)(Gen.listOfN(5,Gen.alphaLowerChar)).head.length shouldEqual  5
  }

}
