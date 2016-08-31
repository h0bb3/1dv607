public class Program {
  public static void main(String[] a_args) {
    System.out.println("Hello Dice Game World");
    
    DiceGame g = new DiceGame();
    
    if (g.play()) {
      System.out.println("Winner...");
    } else {
      System.out.println("Sorry...");
    }
    
  }
}