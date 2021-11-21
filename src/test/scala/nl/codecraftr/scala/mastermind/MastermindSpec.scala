package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.{BLUE, RED}
import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  "four wrong pegs" should "return zero right, zero misplaced" in {
    val result = Mastermind.evaluate(Code(RED, RED, RED, RED))
    assert(result == Result(0, 0))
  }

  "four correct pegs" should "return four right, zero misplaced" in {
    val result = Mastermind.evaluate(Code(BLUE, BLUE, BLUE, BLUE))
    assert(result == Result(4, 0))
  }

  "one correct peg" should "return one correct, zero misplaced" in {
    val result = Mastermind.evaluate(Code(BLUE, RED, RED, RED))
    assert(result == Result(1, 0))
  }
}
