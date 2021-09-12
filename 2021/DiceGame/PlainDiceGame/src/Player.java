public class Player {
  public void haveFun(DiceGame game) {
    System.out.println("Welcome to the Fun Dice Game!");
    if (game.playGame()) {
      System.out.println("You won!");
    } else {
      System.out.println("Sorry you lost!");
    }
  }
}
