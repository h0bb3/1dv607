package model;

public class AmericanDealer extends Dealer {
  public void startGame(Player a_player) {
    if (isGameOver() || getScore() == 0) {
      m_deck = new Deck();
      m_deck.shuffle();
      clearHand();
      a_player.clearHand();
      
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
}