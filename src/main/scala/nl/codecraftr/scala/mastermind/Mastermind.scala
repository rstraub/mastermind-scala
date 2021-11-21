package nl.codecraftr.scala.mastermind

object Mastermind {
  private val code = ("blue", "blue", "blue", "blue")

  def evaluate(guess: (String, String, String, String)): (Int, Int) = {
    var correct = 0
    if (guess._1 == code._1)
      correct += 1
    if (guess._2 == code._2)
      correct += 1
    if (guess._3 == code._3)
      correct += 1
    if (guess._4 == code._4)
      correct += 1

    (correct, 0)
  }
}
