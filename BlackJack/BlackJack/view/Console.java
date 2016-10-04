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
  
  public void presentInstructions() {
    System.out.println("=======================================================");
    System.out.println("Hello Black Jack World");
    System.out.println("p to start a new game, h to hit, s to stand, q to quit");
  }
  
  private void presentHand(String a_start, Iterable<model.Card> a_hand) {
    System.out.println(a_start);
    for(model.Card c : a_hand) {
      System.out.println("" + c.getValue() + " of " + c.getColor());
    }  
    System.out.println("");
  }
  
  public void presentDealerHand(Iterable<model.Card> a_hand) {
    presentHand("Dealer: ", a_hand);
  }
  
  public void presentPlayerHand(Iterable<model.Card> a_hand) {
    presentHand("Player: ", a_hand);
  }
  
  public void collectEvents() {
    m_input = getInputChar();
  }
  
  public boolean wantsToStartNewGame() {
    return m_input == 'p';
  }
  
  public boolean wantsToQuit() {
    return m_input == 'q';
  }
}