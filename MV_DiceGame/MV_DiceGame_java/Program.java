public class Program {
  
  
  
  public static void main(String[] a_args) {
    
    
    model.DiceGame g = new model.DiceGame();
    view.Console ui = new view.Console();
    
    ui.playGame(g);
  }
}