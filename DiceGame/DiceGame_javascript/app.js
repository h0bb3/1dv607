const DiceGame = require('./DiceGame');
const game = new DiceGame();

if (game.play()) {
  console.log('You are a winner!');
} else {
  console.log('Sorry');
}
