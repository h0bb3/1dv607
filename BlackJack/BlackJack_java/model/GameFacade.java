package model;

public class GameFacade {
  Dealer m_dealer;
  Player m_player;
  
  public GameFacade() {
    model.rules.RuleFactory rules = new model.rules.RuleFactory();
    m_dealer = new Dealer(rules);
    m_player = new Player();
  }

  public void start() {
    m_dealer.startGame(m_player);
  }
  
  public void hit() {
    m_dealer.hit(m_player);
  }
  
  public void stand() {
    m_dealer.stand(m_player);
  }
  
  public int getDealerScore() {
    return m_dealer.getScore();
  }
  
  public int getPlayerScore() {
    return m_player.getScore();
  }
  
  public boolean isGameOver() {
    return m_dealer.isGameOver();
  }
  
  public boolean isDealerWinner() {
    return m_dealer.isDealerWinner(m_player);
  }
  
  public Iterable<Card> getDealerHand() {
    return m_dealer.getHand();
  }
  
  public Iterable<Card> getPlayerHand() {
    return m_player.getHand();
  }
}