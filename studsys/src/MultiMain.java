import controller.AdminController;
import model.EmailAddress;
import model.NEString;
import model.Registry;
import view.console.TheUI;
import view.*;

import java.io.IOException;
import java.util.ArrayList;

public class MultiMain {

    public static class UIThread extends Thread {
        model.Registry m_model;
        view.IUI m_view;

        UIThread(model.Registry a_model, view.IUI a_view) {
            m_model = a_model;
            m_view = a_view;
        }

        @Override
        public void run() {
            controller.AdminController c = new AdminController();

            try {
                c.handleAdminOptions(m_model, m_view);
            } catch (IOException e) {
                handleIOException(e);   // maybe this should be pushed to the view instead?
            }
        }

        protected void handleIOException(IOException a_e) {
            a_e.printStackTrace();
        }
    }

    public static class WebSocketClientThread extends UIThread {

        view.websocket.Client m_wsClient;

        WebSocketClientThread(Registry a_model, view.websocket.Client a_wsClient) {
            super(a_model, a_wsClient);
            m_wsClient = a_wsClient;
        }

        @Override
        public void run() {
            try {
                m_wsClient.waitForReady();
            } catch (IOException e) {
                e.printStackTrace();
                m_wsClient.forceClose();
                return;
            }
            super.run();
        }

        @Override
        protected void handleIOException(IOException a_e) {
            if (a_e.getClass() == view.websocket.Frame.ConnectionClosedException.class) {
                System.out.println("Connection Closed By Peer");
                m_wsClient.forceClose();
            } else {
                a_e.printStackTrace();
            }
        }
    }

    public static class WebSocketUIThread extends Thread {
        model.Registry m_model;

        WebSocketUIThread(model.Registry a_model) {
            m_model = a_model;
        }


        @Override
        public void run() {

            view.websocket.Server s = null;
            try {
                s = new view.websocket.Server();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }


            while(true) {
                try {
                    UIThread t = new WebSocketClientThread(m_model, s.acceptClient());
                    t.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String [] a_args) {

        model.Registry m = new model.Registry();
        UIThread console = new UIThread(m, new TheUI());
        UIThread gui = new UIThread(m, new view.gui.TheUI());
        WebSocketUIThread wsUI = new WebSocketUIThread(m);

        m.addNewStudent(new NEString("a"), new EmailAddress(new NEString("a"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("b"), new EmailAddress(new NEString("b"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("c"), new EmailAddress(new NEString("c"), new NEString [] {new NEString("gmail"), new NEString("com")}));
        m.addNewStudent(new NEString("d"), new EmailAddress(new NEString("d"), new NEString [] {new NEString("gmail"), new NEString("com")}));


        console.start();
        gui.start();
        wsUI.start();

        while(console.isAlive() || gui.isAlive());

    }
}
