public class Program {

  public static void main(String[] a_args) {
  
    model.GameFacade game = new model.GameFacade();
    view.Console v = new view.Console();
    controller.Player c = new controller.Player();
    
    while(c.playGame(v, game));
  }
}