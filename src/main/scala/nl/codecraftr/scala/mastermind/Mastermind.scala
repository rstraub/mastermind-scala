package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.Color

case class Mastermind(secret: Code) {
  def evaluate(guess: Code): Result = secret.evaluate(guess)
}

case class Code(first: Color, second: Color, third: Color, fourth: Color) {
  def evaluate(other: Code): Result = {
    var correct = 0
    if (first == other.first)
      correct += 1
    if (second == other.second)
      correct += 1
    if (third == other.third)
      correct += 1
    if (fourth == other.fourth)
      correct += 1
    Result(correct, 0)
  }
}
case class Result(correct: Int, misplaced: Int)

object Color extends Enumeration {
  type Color = Value

  val BLUE, RED = Value
}
