public class Program {
  public static void main(String[] a_args) {
    System.out.println("Hello Dice Game World");
    
    model.DiceGame g = new model.DiceGame();
    
    if (g.play()) {
      System.out.println("Winner...");
    } else {
      System.out.println("Sorry...");
    }
    
  }
}