import controller.AdminController;
import model.EmailAddress;
import model.NEString;

import java.io.IOException;

public class GUIMain {
    public static void main(String [] a_args) {
        controller.AdminController c = new AdminController();
        model.Registry m = new model.Registry();
        view.IUI v = new view.gui.TheUI();

        m.addNewStudent(new NEString("a"), new EmailAddress(new NEString("a"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("b"), new EmailAddress(new NEString("b"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("c"), new EmailAddress(new NEString("c"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("d"), new EmailAddress(new NEString("d"), new NEString [] {new NEString("gmail"), new NEString("com")}));

        try {
            c.handleAdminOptions(m, v);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
