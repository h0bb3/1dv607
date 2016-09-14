package view;

public interface IView {

  public boolean wantsToPlay();
  public void DisplayResult(boolean a_win, int a_dice1Val, int a_dice2Val);
  public void DisplayWelcomeMessage();
  public void DisplayInstructions();

}