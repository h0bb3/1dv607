package model.rules;

class EuroNewGameStrategy implements IStartNewGameStrategy {
  
  public void startGame(model.Player a_player, model.Player a_dealer, model.Deck a_deck) {
    
    model.Card c = a_deck.getTopCard();
    c.show();
    a_player.dealCard(c);
    
    c = a_deck.getTopCard();
    c.show();
    a_dealer.dealCard(c);
    
    c = a_deck.getTopCard();
    c.show();
    a_player.dealCard(c);
  }
}