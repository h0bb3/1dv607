package view.gui;

import model.Student;
import view.AdminOption;
import view.Helper;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentList extends JPanel {

    private Student m_selectedStudent = null;
    private boolean m_doDelete = false;

    public boolean wantsToDeleteStudent(Student a_selectedStudent) {
        return a_selectedStudent == m_selectedStudent && m_doDelete;
    }

    public boolean wantsToChangeStudent(Student a_selectedStudent) {
        return a_selectedStudent == m_selectedStudent && !m_doDelete;
    }

    private class OnStudentAction implements ActionListener {
        Student m_student;
        boolean m_doDelete;

        public OnStudentAction(Student a_student, boolean a_doDelete) {
            m_student = a_student;
            m_doDelete = a_doDelete;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            m_selectedStudent = m_student;
            StudentList.this.m_doDelete = m_doDelete;
        }
    }

    public StudentList() {
        super(new GridBagLayout());
    }

    public void populate(Iterable<Student> a_students) {
        super.removeAll();
        Helper h = new Helper();

        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        int iy = 0;
        for (Student s : a_students) {
            c.gridx = 0; c.gridy = iy;
            c.weightx = 0.9;
            JButton b = new JButton(s.getName().str() + " (" + h.toString(s.getEmail()) + ")");
            b.addActionListener(new OnStudentAction(s, false));
            add(b, c);

            c.gridx = 1; c.gridy = iy;
            c.weightx = 0.1;
            b = new JButton("X");
            b.addActionListener(new OnStudentAction(s, true));
            add(b, c);
            iy++;
        }
        repaint();
        validate();
    }

    public Student showStudentList(Frame a_frame) {
        m_selectedStudent = null;
        m_doDelete = false;
        while (a_frame == null || a_frame.isVisible()) {
            try {
                Thread.sleep(250);
                if (m_selectedStudent != null) {
                    break;
                }
            } catch (InterruptedException e) {

            }
        }

        return m_selectedStudent;
    }
}
