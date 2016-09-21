package view;

public class Console extends BaseConsole implements IView {
  
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
}