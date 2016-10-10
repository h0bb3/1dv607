package view;

public class Console {
  
  private int m_input;
  
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
  
  public void presentInstructions(boolean a_gameStarted) {
    System.out.println("=======================================================");
    System.out.println("Hello Black Jack World");
    if (a_gameStarted) {
      System.out.println("h to hit, s to stand, q to quit");
    } else {
      System.out.println("p to start a new game, q to quit");
    }
    System.out.println("-------------------------------------------------------");
  }
  
  private void presentHand(String a_start, int a_score, Iterable<model.Card> a_hand) {
    if (a_score > 0) {
      System.out.println(a_start + " " + a_score);
      for(model.Card c : a_hand) {
        System.out.println("" + c.getValue() + " of " + c.getColor());
      }  
      System.out.println("");
    }
  }
  
  public void presentWinner(boolean a_isDealerWinner) {
    if (a_isDealerWinner) {
      System.out.println("* Dealer Won! *");
    } else {
      System.out.println("* Player Won! *");
    }
  }
  
  public void presentDealerHand(int a_score, Iterable<model.Card> a_hand) {
    presentHand("Dealer: ", a_score, a_hand);
  }
  
  public void presentPlayerHand(int a_score, Iterable<model.Card> a_hand) {
    presentHand("Player: ", a_score, a_hand);
  }
  
  public void collectEvents() {
    m_input = getInputChar();
  }
  
  public boolean wantsToStartNewGame() {
    return m_input == 'p';
  }
  
  public boolean wantsToHit() {
    return m_input == 'h';
  }
  
  public boolean wantsToStand() {
    return m_input == 's';
  }
  
  public boolean wantsToQuit() {
    return m_input == 'q';
  }
}