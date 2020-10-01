const Dice = require('./Dice');

class DiceGame {

  constructor() {
    this._m_d1 = new Dice();
    this._m_d2 = new Dice();
  }

  play() {
    this._m_d1.roll();
    this._m_d2.roll();
    return this._m_d1.getValue() + this._m_d2.getValue() === 7;
  }
}

module.exports = DiceGame;
