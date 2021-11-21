package nl.codecraftr.scala.mastermind

object Mastermind {
  private val code = Code("blue", "blue", "blue", "blue")

  def evaluate(guess: (String, String, String, String)): (Int, Int) = {
    var correct = 0
    if (guess._1 == code.first)
      correct += 1
    if (guess._2 == code.second)
      correct += 1
    if (guess._3 == code.third)
      correct += 1
    if (guess._4 == code.fourth)
      correct += 1

    (correct, 0)
  }
}

case class Code(first: String, second: String, third: String, fourth: String)
