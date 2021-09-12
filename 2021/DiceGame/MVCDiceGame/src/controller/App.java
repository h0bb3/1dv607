package controller;
import model.DiceGame;
import view.ConsoleUI;

public class App {
    public static void main(String[] args) throws Exception {
        DiceGame funDiceGame = new DiceGame();
        ConsoleUI ui = new ConsoleUI();
        Player p = new Player();
        p.playGame(funDiceGame, ui);
    }
}
