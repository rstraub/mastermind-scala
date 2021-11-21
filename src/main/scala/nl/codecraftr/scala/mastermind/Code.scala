package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.Color

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

  private def misplacedPegs(other: Code) = {
    var counted = Set[Peg]()
    val result = other.pegs.filter(peg => {
      val matched = pegs.diff(counted).find(_.color == peg.color)
      matched.exists((p: Peg) => {
        counted += p
        true
      })
    })
    Code(result)
  }

  private def correctPegs(other: Code) = Code(other.pegs.intersect(pegs))

  private def amountOfPegs() = pegs.size

  private def colors(): List[Color] = pegs.map(_.color).toList
}
