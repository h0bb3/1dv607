package controller;

public class Player {
  
  
  public boolean playGame(view.Console a_view, model.Dealer a_dealer, model.Player a_player) {
    a_view.presentInstructions(!a_dealer.isGameOver() && a_dealer.getScore() > 0);
    a_view.presentDealerHand(a_dealer.getScore(), a_dealer.getHand());
    a_view.presentPlayerHand(a_player.getScore(), a_player.getHand());
    
    if (a_dealer.isGameOver() && a_dealer.getScore() > 0) {
      a_view.presentWinner(a_dealer.isDealerWinner(a_player));
    }
    
    a_view.collectEvents();
    
    if (a_view.wantsToStartNewGame()) {
      a_dealer.startGame(a_player);
      
    } else if (a_view.wantsToHit()) {
      a_dealer.hit(a_player);
      
    } else if (a_view.wantsToStand()) {
      a_dealer.stand(a_player);
    } else if (a_view.wantsToQuit()) {
      return false;
    }
    
    return true;
  }
}