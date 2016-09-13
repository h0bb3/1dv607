package model;

public class DiceGame {
  private Dice m_d1;
  private Dice m_d2;
  
  public DiceGame() {
    m_d1 = new Dice();
    m_d2 = new Dice();
  }
  
  public boolean play() {
    m_d1.roll();
    m_d2.roll();
    
    return m_d1.getValue() + m_d2.getValue() == 7;
  }
  
  public int getValueDice1() {
    return m_d1.getValue();
  }
  
  public int getValueDice2() {
    return m_d2.getValue();
  }
}