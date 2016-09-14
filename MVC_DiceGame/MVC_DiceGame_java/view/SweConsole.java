package view;

public class SweConsole implements IView {
  private int getInputChar() {
    try {
      int c = System.in.read();
      while (c == '\r' || c =='\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }
  
  public boolean wantsToPlay() {
    return getInputChar() != 'a';
  }
  
  public void DisplayResult(boolean a_win, int a_dice1Val, int a_dice2Val) {
    if (a_win) {
      System.out.println("Vann: " + a_dice1Val + " " + a_dice2Val);
    } else {
      System.out.println("Förlorade:" +a_dice1Val + " " + a_dice2Val);
    }
  }
  
  public void DisplayWelcomeMessage() {
    System.out.println("Välkommen till tärningsspelet");
  }
  
  public void DisplayInstructions() {
    System.out.println("Truck en tangent för att spela eller 'a' för att avsluta");
  }
}