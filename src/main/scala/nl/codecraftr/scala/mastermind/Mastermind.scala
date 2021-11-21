package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.Color

case class Mastermind(secret: Code) {
  def evaluate(guess: Code): Result = secret.evaluate(guess)
}

case class Code(private val pegs: Set[Peg]) {
  def this(first: Color, second: Color, third: Color, fourth: Color) {
    this(Set(Peg(1, first), Peg(2, second), Peg(3, third), Peg(4, fourth)))
  }

  def evaluate(other: Code): Result = {
    val correct = correctPegs(other)
    val codeRemainder = Code(pegs diff correct.pegs)
    val otherRemainder = Code(other.pegs diff correct.pegs)
    val misplaced: Int = codeRemainder amountMisplaced otherRemainder
    Result(correct.pegs.size, misplaced)
  }

  private def amountMisplaced(code: Code) = {
    colors().foldRight(0)((peg, count) =>
      if (code.colors().contains(peg))
        count + 1
      else count
    )
  }

  private def colors(): List[Color] = pegs.map(_.color).toList
  private def correctPegs(other: Code) = Code(other.pegs.intersect(pegs))
}

case class Result(correct: Int, misplaced: Int)

case class Peg(position: Int, color: Color)

object Color extends Enumeration {
  type Color = Value

  val YELLOW, BLUE, RED, WHITE, GREEN = Value
}
