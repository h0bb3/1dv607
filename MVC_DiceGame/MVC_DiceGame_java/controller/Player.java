package controller;

public class Player {

  public void playGame(model.DiceGame a_game, view.IView a_view) {
    
    a_view.DisplayWelcomeMessage();
    a_view.DisplayInstructions();
    
    while (a_view.wantsToPlay()) {
      
      a_view.DisplayResult(a_game.play(), a_game.getValueDice1(), a_game.getValueDice2());
      
      a_view.DisplayInstructions();
    }
  }
}