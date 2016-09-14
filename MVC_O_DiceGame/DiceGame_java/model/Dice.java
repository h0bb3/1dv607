package model;

public class Dice {
  
  private int m_value;
  
  public void roll() {
    m_value = (int)(Math.random() * 171717.0) % 6 + 1;
  }
  
  public int getValue() {
    return m_value;
  }
}