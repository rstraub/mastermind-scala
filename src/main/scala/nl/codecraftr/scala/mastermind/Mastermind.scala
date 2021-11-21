package nl.codecraftr.scala.mastermind

object Mastermind {
  private val code = Code("blue", "blue", "blue", "blue")

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

class Color extends Enumeration {
  type Color = Value

  val BLUE = "blue"
  val RED = "red"
}
