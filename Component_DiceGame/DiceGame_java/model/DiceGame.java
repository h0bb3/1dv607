package model;

public class DiceGame {
  private Dice m_d1;
  private Dice m_d2;
  
  private java.util.ArrayList<IDiceRolledObserver> m_subscribers;
  
  public DiceGame() {
    m_d1 = new Dice();
    m_d2 = new Dice();
    m_subscribers = new java.util.ArrayList<IDiceRolledObserver>();
  }
  
  public void addSubscriber(IDiceRolledObserver a_sub) {
    m_subscribers.add(a_sub);
  }
  
  public boolean play() {
    
    m_d1.roll();
    for(IDiceRolledObserver obs : m_subscribers) {
      obs.DiceRolled(m_d1.getValue());
    }
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
    }
    
    m_d2.roll();
    for(IDiceRolledObserver obs : m_subscribers) {
      obs.DiceRolled(m_d2.getValue());
    }
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
    }
    
    return m_d1.getValue() + m_d2.getValue() == 7;
  }
}