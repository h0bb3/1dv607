package model;
public class DiceGame {
  Die d1;
  Die d2;

  public DiceGame() {
    d1 = new Die();
    d2 = new Die();
  }

  public boolean playGame() {
    d1.roll();
    d2.roll();

    return d1.getValue() + d2.getValue() == 7;
  }
}
