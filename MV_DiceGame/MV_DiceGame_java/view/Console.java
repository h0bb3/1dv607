package view;

public class Console {
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
  
  public void playGame(model.DiceGame a_game) {
    System.out.println("Hello Dice Game World");
    System.out.println("Any key to play 'q' to quit");
    while (getInputChar()!='q') {
      if (a_game.play()) {
        System.out.println("Win: " + a_game.getValueDice1() + " " + a_game.getValueDice2());
      } else {
        System.out.println("Lose:" + a_game.getValueDice1() + " " + a_game.getValueDice2());
      }
      
      System.out.println("Any key to play 'q' to quit");
    }
  }
}