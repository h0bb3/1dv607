package controller;

public class Player {
  
  
  public boolean playGame(view.Console a_view, model.GameFacade a_game) {
    a_view.presentInstructions(!a_game.isGameOver() && a_game.getDealerScore() > 0);
    a_view.presentDealerHand(a_game.getDealerScore(), a_game.getDealerHand());
    a_view.presentPlayerHand(a_game.getPlayerScore(), a_game.getPlayerHand());
    
    if (a_game.isGameOver() && a_game.getDealerScore() > 0) {
      a_view.presentWinner(a_game.isDealerWinner());
    }
    
    a_view.collectEvents();
    
    if (a_view.wantsToStartNewGame()) {
      a_game.start();
    } else if (a_view.wantsToHit()) {
      a_game.hit();
      
    } else if (a_view.wantsToStand()) {
      a_game.stand();
    } else if (a_view.wantsToQuit()) {
      return false;
    }
    
    return true;
  }
}