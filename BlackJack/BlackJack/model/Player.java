package model;

import java.util.LinkedList;

public class Player {

  LinkedList<Card> m_hand;
  
  public Player() {
    m_hand = new LinkedList<Card>();
  }
  
  public void dealCard(Card a_c) {
    m_hand.add(a_c);
  }
  
  public Iterable<Card> getHand() {
    return m_hand;
  }
  
}