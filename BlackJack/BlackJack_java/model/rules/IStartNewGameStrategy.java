package model.rules;

public interface IStartNewGameStrategy {

  public void startGame(model.Player a_player, model.Player a_dealer, model.Deck a_deck);
}