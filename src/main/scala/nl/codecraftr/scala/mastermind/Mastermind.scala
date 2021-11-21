package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.{BLUE, Color}

object Mastermind {
  private val code = Code(BLUE, BLUE, BLUE, BLUE)

  def evaluate(guess: Code): Result = {
    var correct = 0
    if (guess.first == code.first)
      correct += 1
    if (guess.second == code.second)
      correct += 1
    if (guess.second == code.third)
      correct += 1
    if (guess.second == code.fourth)
      correct += 1

    Result(correct, 0)
  }
}

case class Code(first: Color, second: Color, third: Color, fourth: Color)
case class Result(correct: Int, misplaced: Int)

object Color extends Enumeration {
  type Color = Value

  val BLUE, RED = Value
}
