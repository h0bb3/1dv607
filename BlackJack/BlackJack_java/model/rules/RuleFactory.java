package model.rules;

public class RuleFactory {

  public IStartNewGameStrategy getStartGameRule() {
    // add advanced behavior here (file parsing whatnot)
    //return new EuroNewGameStrategy();
    return new AmericanNewGameStrategy();
  }
}