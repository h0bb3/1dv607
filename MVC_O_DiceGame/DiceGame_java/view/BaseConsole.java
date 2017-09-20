package view;

public abstract class BaseConsole {
  protected int getInputChar() {
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
  
  public void DisplayDice(int a_faceValue) {
    System.out.println("" + a_faceValue);
  }

}