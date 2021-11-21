package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.BLUE

object Mastermind {
  private val code = Code(BLUE, BLUE, BLUE, BLUE)

  def evaluate(guess: Code): (Int, Int) = {
    var correct = 0
    if (guess.first == code.first)
      correct += 1
    if (guess.second == code.second)
      correct += 1
    if (guess.second == code.third)
      correct += 1
    if (guess.second == code.fourth)
      correct += 1

    (correct, 0)
  }
}

case class Code(first: String, second: String, third: String, fourth: String)

object Color extends Enumeration {
  type Color = Value

  val BLUE = "blue"
  val RED = "red"
}
