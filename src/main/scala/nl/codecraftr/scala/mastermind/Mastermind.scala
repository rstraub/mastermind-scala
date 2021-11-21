package nl.codecraftr.scala.mastermind

object Mastermind {
  private val code = ("blue", "blue", "blue", "blue")

  def evaluate(guess: (String, String, String, String)): (Int, Int) = {
    var correct = 0
    guess.productIterator.foreach(peg =>
     if (peg == code._1 || peg == code._2 || peg == code._3 || peg == code._3) correct += 1
    )

    (correct, 0)
  }
}
