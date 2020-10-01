import controller.AdminController;
import view.console.TheUI;

import java.io.IOException;

public class Main {
    public static void main(String [] a_args) {
        controller.AdminController c = new AdminController();
        model.Registry m = new model.Registry();
        view.IUI v = new TheUI();

        m.addNewStudent("a","a");
        m.addNewStudent("b","b");
        m.addNewStudent("c","c");
        m.addNewStudent("d","d");

        try {
            c.handleAdminOptions(m, v);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
