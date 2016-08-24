package com.prabhat.simulation.util

import scala.util.Random

/**
  * Created by prabhat on 22/08/2016.
  */
case class RGen(rand : Random) {
  def next : (Int, RGen) = (rand.nextInt(), RGen(rand))
}

object RGen {

  def nonNegativeInt(rng: RGen): (Int, RGen) = {
    val (i, r) = rng.next
    (if (i < 0) -(i + 1) else i, r)
  }

  def betweenInt(min: Int, max: Int)(rng : RGen): (Int, RGen) = {
    max - min match {
      case diff if diff > 0 => (rng.rand.nextInt(diff + 1) + min, RGen(rng.rand))
      case nDiff => (min - rng.rand.nextInt(Math.abs(nDiff) + 1) , RGen(rng.rand))
    }

  }

  def double(rng: RGen): (Double, RGen) = {
    val (i, r) = nonNegativeInt(rng)
    (i / (Int.MaxValue.toDouble + 1), r)
  }

  def char(rng: RGen): (Char, RGen) = {
    (rng.rand.nextPrintableChar(), RGen(rng.rand))
  }

  def ints(count: Int)(rng: RGen): (List[Int], RGen) =
    if (count == 0)
      (List(), rng)
    else {
      val (x, r1)  = rng.next
      val (xs, r2) = ints(count - 1)(r1)
      (x :: xs, r2)
    }

}

