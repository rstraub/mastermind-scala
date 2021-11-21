package nl.codecraftr.scala.mastermind

object Mastermind {
  private val code = ("blue", "blue", "blue", "blue")

  def evaluate(guess: (String, String, String, String)): (Int, Int) = {
    if (guess == code)
      (4, 0)
    else
      (0, 0)
  }
}
