package view.gui;

import view.AdminOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOptionsPanel extends JPanel {

    AdminOption m_selection = null;

    public AdminOptionsPanel() {
        super(new GridBagLayout());

        add(createButton("Add New Student", AdminOption.AddNewStudent));

        add(createButton("List all Students", AdminOption.ListAllStudents));
        add(createButton("Quit", AdminOption.Quit));
    }

   private JButton createButton(String a_text, AdminOption a_option) {
        JButton b = new JButton(a_text);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m_selection = a_option;
            }
        });

        return b;
    }

    public AdminOption getAdminOptions(Frame a_frame) {
        m_selection = null;
        while (a_frame == null || a_frame.isVisible()) {
            try {
                Thread.sleep(250);
                if (m_selection != null) {
                    break;
                }
            } catch (InterruptedException e) {

            }
        }
        if (m_selection == null) {
            m_selection = AdminOption.Quit;
        }

        return m_selection;
    }
}
