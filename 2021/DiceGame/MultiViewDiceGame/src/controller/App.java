package controller;
import model.DiceGame;

public class App {
    public static void main(String[] args) throws Exception {
        DiceGame funDiceGame = new DiceGame();
        view.Factory f = new view.Factory();
        view.View ui = f.getView();
        Player p = new Player(funDiceGame, ui);
        p.playGame();
    }
}
