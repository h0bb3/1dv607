package controller;
import model.DiceGame;
import view.View;

public class Player implements model.DiceRolledObserver {
  view.View ui;
  DiceGame game;

  Player(DiceGame g, view.View view) {
    ui = view;
    game = g;

    game.addSubscriber(this);
  }

  // R1 Play Game
  // The Player wants to play the game
  // Game rolls the dices and a winning or loosing message is displayed
  // The Player can choose to play agin or quit
  public void playGame() {
    do {
      ui.showWelcomeMessage();
      if (game.playGame()) {
        ui.showWinningMessage();
      } else {
        ui.showLoosingMessage();
      }
    } while (!ui.promptQuitMessage());
  }

  public void diceRolled(int value) {
    
    ui.showDiceRolledMessage(value);
  }

  
}
