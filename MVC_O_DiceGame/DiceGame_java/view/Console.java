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
  
  public void DisplayResult(boolean a_win) {
    if (a_win) {
      System.out.println("Yay! Win!");
    } else {
      System.out.println("Sorry, you lost...");
    }
  }
  
  public void DisplayWelcomeMessage() {
    System.out.println("Hello Dice Game World");
  }
  
  public void DisplayInstructions() {
    System.out.println("Any key to play 'q' to quit");
  }
  
  public void DisplayDice(int a_faceValue) {
    System.out.println("" + a_faceValue);
  }
  
  
}