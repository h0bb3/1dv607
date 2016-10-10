package model;

import java.util.LinkedList;

public class Player {

  LinkedList<Card> m_hand;
  
  public Player() {
    m_hand = new LinkedList<Card>();
  }
  
  public void clearHand() {
    m_hand = new LinkedList<Card>();
  }
  
  public void showHand() {
    for(Card c : getHand()){
      c.show();
    }
  }
  
  public void dealCard(Card a_c) {
    m_hand.add(a_c);
  }
  
  public Iterable<Card> getHand() {
    return m_hand;
  }
  
  public int getScore() {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    
    int score = 0;

    for(Card c : getHand()) {
        if (c.getValue() != Card.Value.Hidden)
        {
            score += cardScores[c.getValue().ordinal()];
        }
    }

    if (score > 21)
    {
        for(Card c : getHand())
        {
            if (c.getValue() == Card.Value.Ace && score > 21)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  
}