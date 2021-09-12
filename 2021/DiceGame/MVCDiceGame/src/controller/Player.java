package controller;
import model.DiceGame;
import view.ConsoleUI;

public class Player {

  // R1 Play Game
  // The Player wants to play the game
  // Game rolls the dices and a winning or loosing message is displayed
  // The Player can choose to play agin or quit
  public void playGame(DiceGame game, ConsoleUI ui) {
    ui.showWelcomeMessage();
    do {
      if (game.playGame()) {
        ui.showWinningMessage();
      } else {
        ui.showLoosingMessage();
      }
    } while (!ui.promptQuitMessage());
  }

  
}
