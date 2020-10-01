import view.console.TheUI;

public class ServerMain {

    public static void main(String [] a_args) {

        model.Registry m = new model.Registry();

        MultiMain.WebSocketUIThread wsUI = new MultiMain.WebSocketUIThread(m);

        m.addNewStudent("a","a");
        m.addNewStudent("b","b");
        m.addNewStudent("c","c");
        m.addNewStudent("d","d");


        wsUI.start();

        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
