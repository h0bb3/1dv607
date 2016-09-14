package view;

public interface IView {

  public boolean wantsToPlay();
  public void DisplayResult(boolean a_win);
  public void DisplayWelcomeMessage();
  public void DisplayInstructions();
  public void DisplayDice(int a_faceValue);

}