package model;

import java.util.ArrayList;

public class DiceGame {
  Die d1;
  Die d2;
  ArrayList<DiceRolledObserver> subscribers;

  public DiceGame() {
    d1 = new Die();
    d2 = new Die();
    subscribers = new ArrayList<>();
  }

  public void addSubscriber(DiceRolledObserver s) {
    subscribers.add(s);
  }

  public void removeSubscriber(DiceRolledObserver s) {
    subscribers.remove(s);
  }

  public boolean playGame() {
    d1.roll();

    notifySubscribers(d1.getValue());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {

    }

    d2.roll();
    notifySubscribers(d2.getValue());
    
    return d1.getValue() + d2.getValue() == 7;
  }

  private void notifySubscribers(int value) {
    for (DiceRolledObserver s : subscribers) {
      s.diceRolled(value);
    }
  }
}
