package model;

import java.util.LinkedList;
import java.util.Iterator;

class Dealer extends Player {

  private Deck m_deck;
  model.rules.IStartNewGameStrategy m_rule;

  public Dealer(model.rules.RuleFactory a_rules) {
    m_deck = null; 
    m_rule = a_rules.getStartGameRule();
  }
  
  public boolean isGameOver() {
    return m_deck == null && getScore() > 0;
  }
  
  public boolean isDealerWinner(Player a_player) {
    if (isGameOver()) {
      if (a_player.getScore() > 21) {
        return true;
      }
      if (getScore() > 21) {
        return false;
      } else {
        return getScore() >= a_player.getScore();
      }
    }
    return false;
  }
  
  public void hit(Player a_player) {
    if (m_deck != null) {
      Card c = m_deck.getTopCard();
      c.show();
      a_player.dealCard(c);
      if (a_player.getScore() > 21) {
        stand(a_player);
      }      
    }
  }
  
  public void stand(Player a_player) {
    if (m_deck != null) {
      
      showHand();
      
      if (a_player.getScore() <= 21) {
        while (getScore() < 17) {
          hit(this);
        }
      }
      
      m_deck = null;
       
    }
  }
  
  public void startGame(Player a_player) {
    if (isGameOver() || getScore() == 0) {
      m_deck = new Deck();
      m_deck.shuffle();
      clearHand();
      a_player.clearHand();
      
      
      m_rule.startGame(a_player, this, m_deck);
    }
  }
}