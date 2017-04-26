public class Program {
  
  public static void main(String[] a_args) {
    
    model.DiceGame g = new model.DiceGame();
    view.IView v = new view.Console();
    controller.Player c = new controller.Player(v);
    
    c.playGame(g);
  }
}