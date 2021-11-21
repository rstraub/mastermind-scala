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
      colors().foldRight(0)((peg, count) =>
        if (code.colors().contains(peg))
          count + 1
        else count
      )
    }
  }

  private def amountCorrect(other: Code) = correctPegs(other).size
  private def correctPegs(other: Code) = other.pegs().intersect(pegs())
  private def pegs(): Set[Peg] = Set(first, second, third, fourth)
  private def colors(): List[Color] = pegs().map(_.color).toList
}

case class Result(correct: Int, misplaced: Int)
case class Peg(position: Int, color: Color)

object Color extends Enumeration {
  type Color = Value

  val YELLOW, BLUE, RED, WHITE, GREEN = Value
}
