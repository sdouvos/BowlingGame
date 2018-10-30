class Game {
  private var rolls: Array[Int] = new Array[Int](21)
  private var currentRoll: Int = 0

  def roll(pins: Int) = {
    rolls(currentRoll) = pins
    currentRoll += 1
  }

  def score(): Int = {
    var score: Int = 0
    val frames: Array[Int] = new Array[Int](10)
    var frameIndex = 0
    frames.toStream.foreach(
      frame => {
        if (isStrike(frameIndex)) {
          score += 10 + strikeBonus(frameIndex)
          frameIndex += 1
        }
        else if (isSpare(frameIndex)) {
          score += 10 + spareBonus(frameIndex)
          frameIndex += 2

        }
        else {
          score += sumOfBallsInFrame(frameIndex)
          frameIndex += 2
        }
      }
    )
    score
  }

  private def sumOfBallsInFrame(frameIndex: Int) = {
    rolls(frameIndex) + rolls(frameIndex + 1)
  }

  private def spareBonus(frameIndex: Int) = {
    rolls(frameIndex + 2)
  }

  private def strikeBonus(frameIndex: Int) = {
    rolls(frameIndex + 1) + rolls(frameIndex + 2)
  }

  private def isStrike(frameIndex: Int) = {
    rolls(frameIndex) == 10
  }

  private def isSpare(frameIndex: Int) = {
    rolls(frameIndex) + rolls(frameIndex + 1) == 10
  }
}

