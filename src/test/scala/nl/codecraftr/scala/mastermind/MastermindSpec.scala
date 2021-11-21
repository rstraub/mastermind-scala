package nl.codecraftr.scala.mastermind

import nl.codecraftr.scala.mastermind.Color.{BLUE, GREEN, RED, WHITE, YELLOW}
import org.scalatest.flatspec.AnyFlatSpec

class MastermindSpec extends AnyFlatSpec {
  private val allBlue = Mastermind(new Code(BLUE, BLUE, BLUE, BLUE))
  private val mixed = Mastermind(new Code(BLUE, RED, WHITE, GREEN))

  "four wrong pegs" should "count as zero correct, zero misplaced" in {
    val result = allBlue evaluate new Code(RED, RED, RED, RED)
    assert(result == Result(0, 0))
  }

  "four correct pegs" should "count as four correct, zero misplaced" in {
    val result = allBlue evaluate new Code(BLUE, BLUE, BLUE, BLUE)
    assert(result == Result(4, 0))
  }

  "a correct peg" should "count as one correct peg" in {
    val result = allBlue evaluate new Code(BLUE, RED, RED, RED)
    assert(result == Result(1, 0))
  }

  "a misplaced peg" should "count as one misplaced peg" in {
    val result = mixed evaluate new Code(YELLOW, YELLOW, YELLOW, BLUE)
    assert(result == Result(0, 1))
  }

  "a misplaced and correct peg" should "count as one correct, one misplaced" in {
    val result = mixed evaluate new Code(BLUE, YELLOW, GREEN, YELLOW)
    assert(result == Result(1, 1))
  }

  "a correct peg" should "have precedence over misplaced pegs" in {
    val result = mixed evaluate new Code(BLUE, YELLOW, YELLOW, BLUE)
    assert(result == Result(1, 0))
  }
}
