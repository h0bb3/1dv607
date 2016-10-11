public class Program {

  public static void main(String[] a_args) {
  
    model.rules.IStartNewGameStrategy rule = new model.rules.AmericanNewGameStrategy();
    
    model.Dealer d = new model.Dealer(rule);
    model.Player p = new model.Player();
    
    view.Console v = new view.Console();
    controller.Player c = new controller.Player();
    
    while(c.playGame(v, d, p));
  }
}