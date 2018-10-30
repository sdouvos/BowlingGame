import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, FlatSpec, Matchers}

class BowlingGameSpec extends FlatSpec with Matchers with BeforeAndAfterEach {
  var game:Game = _

  override def beforeEach() {
    game = new Game
    super.beforeEach() // To be stackable, must call super.beforeEach
  }

  def rollMany(n:Int, pins:Int): Unit ={
    (1 to n).toStream
      .foreach(counter => game.roll(pins))
  }

  "Gutter Game" should " be zero" in {
    rollMany(20, 0)
    assert(0 === game.score())
  }

  "All one " should "be 20" in {
    rollMany(20, 1)

    assert(20 === game.score())
  }

  "One Spare" should "be 16 " in{
    rollSpare
    game.roll(3)
    rollMany(17,0)
    assert(16 === game.score())

  }

  "One Strike" should "be 24 " in{
    rollStrike
    game.roll(3)
    game.roll(4)
    rollMany(16,0)
    assert(24 === game.score())

  }

  "Perfect Game Strike" should "be 300 " in{
    rollMany(12, 10)
    assert(300 === game.score())

  }

  private def rollStrike = {
    game.roll(10)
  }

  private def rollSpare = {
    game.roll(5)
    game.roll(5)
  }
}
