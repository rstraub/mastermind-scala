package nl.codecraftr.scala.mastermind

import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  "four wrong pegs" should "return zero right, zero misplaced" in {
    val result = Mastermind.evaluate("blue", "blue", "blue", "blue")
    assert(result == (0, 0))
  }
}
