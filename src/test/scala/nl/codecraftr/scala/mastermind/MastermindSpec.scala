package nl.codecraftr.scala.mastermind

import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  "four wrong pegs" should "return zero right, zero misplaced" in {
    val result = Mastermind.evaluate(Code("red", "red", "red", "red"))
    assert(result == (0, 0))
  }

  "four correct pegs" should "return four right, zero misplaced" in {
    val result = Mastermind.evaluate(Code("blue", "blue", "blue", "blue"))
    assert(result == (4, 0))
  }

  "one correct peg" should "return one correct, zero misplaced" in {
    val result = Mastermind.evaluate(Code("blue", "red", "red", "red"))
    assert(result == (1, 0))
  }
}
