package view;

public class ConsoleUI {
  public void showWelcomeMessage() {
    System.out.println("Welcome to the Fun Dice Game!");
  }

  public void showWinningMessage() {
    System.out.println("You won!");
  }

  public void showLoosingMessage() {
    System.out.println("Sorry you lost!");
  }

  public boolean promptQuitMessage() {
    System.out.println("Press q to quit or any key to play again...");

    return getInputChar() == 'q';
  }

  private int getInputChar() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }
}
