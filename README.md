##Bowling Game Kata in Scala

This is the famous [Bowling Game Kata](http://kata-log.rocks/bowling-game-kata) in Scala


### Rules

- The game consists of 10 frames.  
- In each frame the player has 2 opportunities to knock down 10 pins.  
- The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.
- A spare is when the player knocks down all 10 pins in 2 tries.  
    - The bonus for that frame is the number of pins knocked down by the next roll.
- A strike is when the player knocks down all 10 pins on his first try.
    - The bonus for that frame is the value of the next two balls rolled.  
- In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
  balls to complete the frame.  However no more than three balls can be rolled in
  tenth frame.
  

### Requirements
Write a class Game that has two methods

- void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
- int score() returns the total score for that game.

### Refs
- [kata-log.rocks](http://kata-log.rocks/bowling-game-kata)
- [Robert C. Martin](butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt)

### Getting Started
- sbt project with scala test

