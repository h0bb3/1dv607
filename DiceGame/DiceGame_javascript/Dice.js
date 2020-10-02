class Dice {

  constructor() {
    this._m_value = 0;
  }

  roll() {
    this._m_value = Math.floor(Math.random() * 6) + 1;
  }

  getValue() {
    return this._m_value;
  }
}

module.exports = Dice;
