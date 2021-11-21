package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.Color

case class Mastermind(secret: Code) {
  def evaluate(guess: Code): Attempt = secret evaluate guess
}

case class Code(private val pegs: Set[Peg]) {
  def this(first: Color, second: Color, third: Color, fourth: Color) {
    this(Set(Peg(1, first), Peg(2, second), Peg(3, third), Peg(4, fourth)))
  }

  def evaluate(other: Code): Attempt = {
    val correct = correctPegs(other)
    val codeRemainder = Code(pegs diff correct.pegs)
    val otherRemainder = Code(other.pegs diff correct.pegs)
    val misplaced = codeRemainder misplacedPegs otherRemainder
    Attempt(correct.amountOfPegs(), misplaced.amountOfPegs())
  }

  private def misplacedPegs(other: Code) = Code(other.pegs.filter(peg => colors().contains(peg.color)))

  private def colors(): List[Color] = pegs.map(_.color).toList

  private def correctPegs(other: Code) = Code(other.pegs.intersect(pegs))
  private def amountOfPegs() = pegs.size
}



object Color extends Enumeration {
  type Color = Value

  val YELLOW, BLUE, RED, WHITE, GREEN = Value
}
