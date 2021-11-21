package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.{BLUE, RED}
import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  private val mastermind = Mastermind(Code(BLUE, BLUE, BLUE, BLUE))

  "four wrong pegs" should "return zero right, zero misplaced" in {
    val result = mastermind evaluate Code(RED, RED, RED, RED)
    assert(result == Result(0, 0))
  }

  "four correct pegs" should "return four right, zero misplaced" in {
    val result = mastermind evaluate Code(BLUE, BLUE, BLUE, BLUE)
    assert(result == Result(4, 0))
  }

  "one correct peg" should "return one correct, zero misplaced" in {
    val result = mastermind evaluate Code(BLUE, RED, RED, RED)
    assert(result == Result(1, 0))
  }
}
