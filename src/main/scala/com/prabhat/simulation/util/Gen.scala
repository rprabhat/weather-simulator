package com.prabhat.simulation.util

import com.prabhat.simulation.config.MinMax

import scala.collection.immutable.Stream.Empty
import scala.util.Random

/**
  * Created by prabhat on 21/08/2016.
  */
case class Gen[+A](sample: State[RGen, A]) {

  def map[B](f: A => B): Gen[B] = Gen(sample.map(f))

  def flatMap[B](f: A => Gen[B]): Gen[B] =
    Gen(sample.flatMap(a => f(a).sample))

  def listOfN(size: Int): Gen[List[A]] = Gen.listOfN(size, this)

  def listOfN(size: Gen[Int]): Gen[List[A]] =
    size flatMap (n => this.listOfN(n))

}

object Gen {

  type minMaxD = MinMax[Double]
  type minMaxI = MinMax[Int]

  def const[A](x : A) : Gen[A] =
    Gen(State.unit().map(_ => x))

  def listOfN[A](n: Int, g: Gen[A]): Gen[List[A]] =
    Gen(State.sequence(List.fill(n)(g.sample)))

  def choose(i: Double, j: Double): Gen[Double] =
    Gen(State(RGen.double).map(d => i + d * (j - i)))

  def choose(minMax: minMaxD): Gen[Double] =
     choose(minMax.min, minMax.max)

  def choose(i: Int, j: Int): Gen[Int] =
    Gen(State(RGen.betweenInt(i,j)))

  def chooseInt(minMaxI: minMaxI): Gen[Int] =
    choose(minMaxI.min, minMaxI.max)

  def choose(i: Char, j: Char): Gen[Char] =
    Gen(State(RGen.betweenInt(i, j))).map(_.toChar)

  def numChar: Gen[Char] = choose(48.toChar, 57.toChar)

  def alphaUpperChar: Gen[Char] = choose(65.toChar, 90.toChar)

  def alphaLowerChar: Gen[Char] = choose(97.toChar, 122.toChar)

  def generate[A](n: Int)(as: Gen[A]) = {
    randomStream(as)(RGen(Random)).zip(Stream.from(0)).take(n).map{
      case(a,i) => a
    }
  }

  def randomStream[A](g: Gen[A])(rng: RGen): Stream[A] =
    unfold(rng)(rng => Some(g.sample.run(rng)))

  def unfold[A, B](start: B)(f: B => Option[Tuple2[A, B]]): Stream[A] =
    f(start) match {
      case Some((elem, next)) => elem #:: unfold(next)(f)
      case None => Empty
    }
}
