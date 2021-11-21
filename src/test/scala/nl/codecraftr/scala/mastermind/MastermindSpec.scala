package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.{BLUE, RED, YELLOW}
import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  private val allBlue = Mastermind(Code(BLUE, BLUE, BLUE, BLUE))
  private val aBlue = Mastermind(Code(BLUE, RED, RED, RED))

  "four wrong pegs" should "count as zero correct, zero misplaced" in {
    val result = allBlue evaluate Code(RED, RED, RED, RED)
    assert(result == Result(0, 0))
  }

  "four correct pegs" should "count as four correct, zero misplaced" in {
    val result = allBlue evaluate Code(BLUE, BLUE, BLUE, BLUE)
    assert(result == Result(4, 0))
  }

  "a correct peg" should "count as one correct peg" in {
    val result = allBlue evaluate Code(BLUE, RED, RED, RED)
    assert(result == Result(1, 0))
  }

  "a misplaced peg" should "count as one misplaced peg" in {
    val result = aBlue evaluate Code(YELLOW, YELLOW, YELLOW, BLUE)
    assert(result == Result(0, 1))
  }

  "a correct peg" should "have precedence over misplaced pegs" in {
    val result = aBlue evaluate Code(BLUE, YELLOW, YELLOW, BLUE)
    assert(result == Result(1, 0))
  }
}
