package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.Color

case class Mastermind(secret: Code) {
  def evaluate(guess: Code): Result = secret.evaluate(guess)
}

case class Code(first: Peg, second: Peg, third: Peg, fourth: Peg) {
  def this(first: Color, second: Color, third: Color, fourth: Color) {
    this(Peg(1, first), Peg(2, second), Peg(3, third), Peg(4, fourth))
  }

  def evaluate(other: Code): Result = {
    val correct: Int = amountCorrect(other)
    val misplaced: Int = amountMisplaced(other)
    Result(correct, misplaced)
  }

  private def amountMisplaced(code: Code) = {
    if (amountCorrect(code) != 0) 0 else {
      pegs().foldRight(0)((peg, count) =>
        if (code.pegs().contains(peg))
          count + 1
        else count
      )
    }
  }

  def pegs(): List[Color] = List(first, second, third, fourth).map(_.color)

  private def amountCorrect(other: Code) = {
    var correct = 0
    if (first == other.first)
      correct += 1
    if (second == other.second)
      correct += 1
    if (third == other.third)
      correct += 1
    if (fourth == other.fourth)
      correct += 1
    correct
  }
}

case class Result(correct: Int, misplaced: Int)
case class Peg(position: Int, color: Color)

object Color extends Enumeration {
  type Color = Value

  val YELLOW, BLUE, RED, WHITE, GREEN = Value
}
