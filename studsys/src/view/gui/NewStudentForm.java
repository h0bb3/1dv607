package view.gui;

import model.Student;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class NewStudentForm  extends JPanel {
    protected JTextField m_name;
    protected JTextField m_email;

    private boolean m_cancelClicked, m_addClicked;
    private final JButton m_addBtn;
    private Student m_changedStudent;

    public NewStudentForm() {
        super(new GridBagLayout());

        m_cancelClicked = false;
        m_addClicked = false;

        m_name = new JTextField();
        m_email = new JTextField();

        JLabel nameLabel = new JLabel("Name:", SwingConstants.RIGHT);
        nameLabel.setLabelFor(m_name);

        JLabel emailLabel = new JLabel("E-mail:", SwingConstants.RIGHT);
        nameLabel.setLabelFor(m_email);


        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0.1;
        c.gridx = 0; c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, c);

        c.weightx = 0.9;
        c.gridx = 1;
        add(m_name, c);

        c.weightx = 0.1;
        c.gridx = 0; c.gridy = 1;
        add(emailLabel, c);

        c.weightx = 0.9;
        c.gridx = 1;
        add(m_email, c);

        c.weightx = 0.1;
        c.gridx = 0; c.gridy = 2;
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m_cancelClicked = true;
            }
        });

        add(cancel, c);

        m_addBtn = new JButton("Add Student");
        m_addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m_addClicked = true;
            }
        });
        c.weightx = 0.9;
        c.gridx = 1;
        m_addBtn.setEnabled(false);
        add(m_addBtn, c);

        DocumentListener onTextChange = new DocumentListener() {


            @Override
            public void insertUpdate(DocumentEvent e) {
                m_addBtn.setEnabled(m_name.getText().length() > 0 && m_email.getText().length() > 0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                insertUpdate((e));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                insertUpdate(e);
            }
        };

        m_name.getDocument().addDocumentListener(onTextChange);
        m_email.getDocument().addDocumentListener(onTextChange);
    }

    private void setTexts(String a_name, String a_email, String a_button) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                m_name.setText(a_name);
                m_email.setText(a_email);
                m_addBtn.setText(a_button);
            }
        });
    }


    public boolean showStudentForm(JFrame a_frame, Student a_selectedStudent) {
        m_addClicked = false;
        m_cancelClicked = false;
        m_changedStudent = null;

        if (a_selectedStudent != null) {

            setTexts(a_selectedStudent.getName(), a_selectedStudent.getEmail(), "Change Student");
        } else {
            setTexts("", "", "Add Student");
        }

        // here we need to block and wait for form
        while (a_frame == null || a_frame.isVisible()) {
            try {
                Thread.sleep(250);
                if (m_changedStudent != null) {
                    a_selectedStudent = m_changedStudent;
                    m_changedStudent = null;
                    setTexts(a_selectedStudent.getName(), a_selectedStudent.getEmail(), "Change Student");
                }
                if (m_cancelClicked || m_addClicked) {
                    break;
                }
            } catch (InterruptedException e) {

            }
        }

        // examine if canceled...
        if (m_addClicked) {
            m_addClicked = false;
            return true;
        }

        return false;
    }

    public String getName() {
        // wait for the form to be ok
        return m_name.getText();
    }

    public String getEmail() {
        // wait for the form to be ok
        return m_email.getText();
    }

    public void showAddedStudentConfirmation(Student a_s) {
        JOptionPane.showMessageDialog(
                null, "Student (" + a_s.getName() + " " + a_s.getEmail() + ") was added.",
                "Student Added", INFORMATION_MESSAGE);
    }

    public void setChangedStudent(Student a_newStudent) {
        // we need to sleep until a previous change has been handled
        while (m_changedStudent != null) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        m_changedStudent = a_newStudent;
    }
}
