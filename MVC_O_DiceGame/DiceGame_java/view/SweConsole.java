package view;

public class SweConsole extends BaseConsole implements IView {  
  public boolean wantsToPlay() {
    return getInputChar() != 'a';
  }
  
  public void DisplayResult(boolean a_win) {
    if (a_win) {
      System.out.println("Yay du vann! ");
    } else {
      System.out.println("Äsch du förlorade...");
    }
  }
  
  public void DisplayWelcomeMessage() {
    System.out.println("Välkommen till tärningsspelet");
  }
  
  public void DisplayInstructions() {
    System.out.println("Truck en tangent för att spela eller 'a' för att avsluta");
  }
}