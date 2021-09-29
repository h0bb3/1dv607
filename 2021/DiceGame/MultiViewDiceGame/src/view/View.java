package view;

public interface View {
  void showWelcomeMessage();
  void showWinningMessage();
  void showLoosingMessage();
  boolean promptQuitMessage();
  void showDiceRolledMessage(int diceValue);
}
