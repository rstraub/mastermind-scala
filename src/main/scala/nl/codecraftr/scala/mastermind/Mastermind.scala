package nl.codecraftr.scala.mastermind

case class Mastermind(secret: Code) {
  def evaluate(guess: Code): Attempt = secret evaluate guess
}


