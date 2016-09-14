package view;

public class Console implements IView {
  public int getInputChar() {
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
    return getInputChar() != 'q';
  }
  
  public void DisplayResult(boolean a_win, int a_dice1Val, int a_dice2Val) {
    if (a_win) {
      System.out.println("Win: " + a_dice1Val + " " + a_dice2Val);
    } else {
      System.out.println("Lose:" +a_dice1Val + " " + a_dice2Val);
    }
  }
  
  public void DisplayWelcomeMessage() {
    System.out.println("Hello Dice Game World");
  }
  
  public void DisplayInstructions() {
    System.out.println("Any key to play 'q' to quit");
  }
}