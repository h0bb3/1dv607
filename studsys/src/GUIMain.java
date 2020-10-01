import controller.AdminController;

import java.io.IOException;

public class GUIMain {
    public static void main(String [] a_args) {
        controller.AdminController c = new AdminController();
        model.Registry m = new model.Registry();
        view.IUI v = new view.gui.TheUI();

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
