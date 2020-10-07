import model.EmailAddress;
import model.NEString;
import view.console.TheUI;

public class ServerMain {

    public static void main(String [] a_args) {

        model.Registry m = new model.Registry();

        MultiMain.WebSocketUIThread wsUI = new MultiMain.WebSocketUIThread(m);

        m.addNewStudent(new NEString("a"), new EmailAddress(new NEString("a"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("b"), new EmailAddress(new NEString("b"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("c"), new EmailAddress(new NEString("c"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("d"), new EmailAddress(new NEString("d"), new NEString [] {new NEString("gmail"), new NEString("com")}));

        wsUI.start();

        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
