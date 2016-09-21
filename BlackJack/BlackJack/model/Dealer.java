package model;

public class Dealer {

  Deck m_deck;
  
  public Dealer() {
    m_deck = new Deck();
    m_deck.shuffle();
  }
}