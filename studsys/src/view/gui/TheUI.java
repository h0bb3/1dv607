package view.gui;

import model.Student;
import view.AdminOption;
import view.IUI;
import view.StudentOption;

import javax.swing.*;

public class TheUI implements IUI {

    NewStudentForm m_newStudentForm = null;
    AdminOptionsPanel m_newAdminOptionsPanel = null;
    StudentList m_studentList = null;
    JFrame m_window = null;

    public TheUI() {
        if (m_window == null) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    m_newAdminOptionsPanel = new AdminOptionsPanel();
                    m_newStudentForm = new NewStudentForm();
                    m_studentList = new StudentList();
                    m_window = createGUI();

                }
            });
        }

        while (m_newAdminOptionsPanel == null || m_newStudentForm == null || m_studentList == null || m_window == null) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {

            }
        }
    }

    @Override
    public boolean showStudentForm(Student a_selectedStudent) {
        showGUI(m_window, m_newStudentForm);
        return m_newStudentForm.showStudentForm(m_window, a_selectedStudent);
    }

    @Override
    public String getName() {
        return m_newStudentForm.getName();
    }

    @Override
    public String getEmail() {
        return m_newStudentForm.getEmail();
    }

    @Override
    public void showAddedStudentConfirmation(Student a_s) {
        m_newStudentForm.showAddedStudentConfirmation(a_s);
    }

    @Override
    public Student showStudentList(Iterable<Student> students) {
        m_studentList.populate(students);
        showGUI(m_window, m_studentList);
        return m_studentList.showStudentList(m_window);
    }

    @Override
    public AdminOption getAdminOptions() {

        showGUI(m_window, m_newAdminOptionsPanel);
        AdminOption ret = m_newAdminOptionsPanel.getAdminOptions(m_window);

        if (ret == AdminOption.Quit) {
            m_window.setVisible(false);
            m_window.dispose();
        }

        return ret;
    }

    @Override
    public StudentOption getStudentOptions(Student a_selectedStudent) {
        if (m_studentList.wantsToDeleteStudent(a_selectedStudent)) {
            return StudentOption.Delete;
        } else if (m_studentList.wantsToChangeStudent(a_selectedStudent)) {
            return StudentOption.Change;
        } else {
            return StudentOption.None;
        }
    }

    @Override
    public void onAddNewStudent(Iterable<Student> a_allStudents, Student a_newStudent) {
        // if we are showing the list of students we should add the new student to that list...
        if (m_window.getContentPane().getComponent(0) == m_studentList) {
            m_studentList.populate(a_allStudents);
        }
    }

    @Override
    public void onDeleteStudent(Iterable<Student> a_allStudents, Student a_deletedStudent) {
        // if we are showing the list of students we should add the new student to that list...

        if (m_window.getContentPane().getComponent(0) == m_studentList) {
            m_studentList.populate(a_allStudents);
        }

        // what should we do if we are currently changing the student that has been deleted?
    }

    @Override
    public void onChangeActiveStudent(Student a_newStudent) {
        if (m_window.getContentPane().getComponent(0) == m_newStudentForm) {
            m_newStudentForm.setChangedStudent(a_newStudent);
        }
    }

    private JFrame createGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Student Admin System Deluxe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        return frame;
    }

    private JFrame showGUI(JFrame a_frame, JPanel a_panel) {

        boolean panelExists = false;
        for (int cIx = 0; cIx < a_frame.getContentPane().getComponentCount(); cIx++) {
            if (a_frame.getContentPane().getComponent(cIx) != a_panel) {
                a_frame.getContentPane().remove(cIx);
                cIx--;
            } else {
                panelExists = true;
            }
        }


        //Add contents to the window.
        if (!panelExists) {
            a_frame.add(a_panel);

            //Display the window.
            a_frame.pack();
            a_frame.setVisible(true);
        }
        a_frame.repaint();
        a_frame.validate();
        a_frame.toFront();
        a_frame.requestFocus();
        return a_frame;
    }
}
