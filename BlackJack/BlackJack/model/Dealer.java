package model;

import java.util.LinkedList;
import java.util.Iterator;

public class Dealer {

  LinkedList<Card> m_hand;
  Deck m_deck;
  
  public Dealer() {
    m_deck = new Deck();
    m_deck.shuffle();
    m_hand = new LinkedList<Card>();
  }
  
  public void dealCard(Card a_c) {
    m_hand.add(a_c);
  }
  
  public Iterable<Card> getHand() {
    return m_hand;
  }
  
  public void startGame(Player a_player) {
    Card c = m_deck.getTopCard();
    c.show();
    a_player.dealCard(c);
    
    c = m_deck.getTopCard();
    c.show();
    dealCard(c);

    c = m_deck.getTopCard();
    c.show();
    a_player.dealCard(c);
    
    c = m_deck.getTopCard();
    dealCard(c);
    
  }
}