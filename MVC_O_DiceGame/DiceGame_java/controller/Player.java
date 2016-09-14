package controller;

public class Player implements model.IDiceRolledObserver {
  
  private view.IView m_view;
  
  public Player(view.IView a_view) {
    m_view = a_view;
  }

  public void playGame(model.DiceGame a_game) {
    
    a_game.addSubscriber(this);
    
    m_view.DisplayWelcomeMessage();
    m_view.DisplayInstructions();
    
    while (m_view.wantsToPlay()) {
      
      m_view.DisplayResult(a_game.play());
      
      m_view.DisplayInstructions();
    }
  }
  
  public void DiceRolled(int a_faceValue) {
    m_view.DisplayDice(a_faceValue);
  }
  
}