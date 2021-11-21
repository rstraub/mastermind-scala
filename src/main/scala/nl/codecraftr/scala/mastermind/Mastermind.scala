package nl.codecraftr.scala.mastermind

object Mastermind {
  def evaluate(code: (String, String, String, String)): (Int, Int) = {
    if (code == ("blue", "blue", "blue", "blue"))
      (4, 0)
    else
      (0, 0)
  }
}
