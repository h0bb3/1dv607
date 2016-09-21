package model;

public class DiceGame {
  private Dice m_d1;
  private Dice m_d2;
  private Dice m_d3;
  
  private java.util.ArrayList<IDiceRolledObserver> m_subscribers;
  
  public DiceGame() {
    m_d1 = new Dice();
    m_d2 = new Dice();
    m_d3 = new Dice();
    m_subscribers = new java.util.ArrayList<IDiceRolledObserver>();
  }
  
  public void addSubscriber(IDiceRolledObserver a_sub) {
    m_subscribers.add(a_sub);
  }
  
  private void rollDice(Dice a_dice) {
    a_dice.roll();
    for(IDiceRolledObserver obs : m_subscribers) {
      obs.DiceRolled(a_dice.getValue());
    }
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
    }
  }
  
  public boolean play() {
    
    rollDice(m_d1);
    rollDice(m_d2);
    rollDice(m_d3);
    
    return m_d1.getValue() + m_d2.getValue() + m_d3.getValue() == 9;
  }
}