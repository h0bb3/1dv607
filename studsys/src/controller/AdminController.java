package controller;

import model.Registry;
import model.Student;
import view.IUI;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class AdminController implements model.Registry.IEventListener {

    view.IUI m_ui;
    model.Registry m_reg;
    Student m_activeStudent = null;




    public void handleAdminOptions(model.Registry a_registry, view.IUI a_ui) throws IOException {

        m_ui = a_ui;
        m_reg = a_registry;
        a_registry.addEventListener(this);
        boolean done = false;
        while (!done) {
            view.AdminOption choice = a_ui.getAdminOptions();
            switch (choice) {
                case AddNewStudent:
                    addNewStudent(a_registry, a_ui);
                    break;

                case ListAllStudents:
                    listStudents(a_registry, a_ui);
                    break;

                case Quit:
                default:
                    done = true;
                    break;
            }
        }

        a_registry.removeEventListener(this);
    }

    private Student changeStudent(Registry a_registry, Student a_selectedStudent, IUI a_ui) {

        try {
            if (a_ui.showStudentForm(a_selectedStudent)) {
                m_activeStudent = a_registry.change(m_activeStudent, a_ui.getName(), a_ui.getEmail());
            } else {
                m_activeStudent = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return m_activeStudent;
    }

    public void addNewStudent(model.Registry a_registry, view.IUI a_ui ) throws IOException {      // 1. Starts when the admin wants to add a student

        while (true) {
            if (a_ui.showStudentForm(null)) {                                               // 2. System asks for the students name and email
                // 3. Admin supplies the info and confirms
                Student s = a_registry.addNewStudent(a_ui.getName(), a_ui.getEmail()); // 4. The system adds the student
                if (s != null) {
                    a_ui.showAddedStudentConfirmation(s);                                    //      and shows a confirmation
                } else {
                    // some error handling                                               // 4.1 The another student with same email already exists
                }
            } else {
                // some error handling or user cancelation                                // 3.1 The admin cancels the creation
                break;
            }
        }
    }

    public void listStudents(Registry a_registry, IUI a_ui) throws IOException {

        m_activeStudent = a_ui.showStudentList(a_registry.getStudents());
        while (m_activeStudent != null) {
            handleStudentOptions(a_registry, m_activeStudent, a_ui);
            m_activeStudent = a_ui.showStudentList(a_registry.getStudents());
        }
    }

    private void handleStudentOptions(Registry a_registry, Student a_selectedStudent, IUI a_ui) throws IOException {
        boolean done = false;
        while (!done) {
            view.StudentOption choice = a_ui.getStudentOptions(a_selectedStudent);
            switch (choice) {
                case Delete:
                    a_registry.remove(a_selectedStudent);
                    done = true;
                    break;
                case Change:
                    a_selectedStudent = changeStudent(a_registry, a_selectedStudent, a_ui);
                    if (a_selectedStudent == null) {
                        done = true;
                    }
                    break;
                case None:
                default:
                    done = true;
                    break;
            }
        }
    }

    @Override
    public void onAddNewStudent(Iterable<Student> a_allStudents, Student a_student) {
        // basically only the ui needs to know this
        m_ui.onAddNewStudent(a_allStudents, a_student);
    }

    @Override
    public void onChangeStudent(Student a_oldStudent, Student a_newStudent) {
        // possibly we are working on this student
        if (m_activeStudent == a_oldStudent) {
            m_activeStudent = a_newStudent;
            m_ui.onChangeActiveStudent(a_newStudent);
        }

    }

    @Override
    public void onDeleteStudent(Student a_deletedStudent) {
        // possibly we are working on this student

        // ui needs to know
        m_ui.onDeleteStudent(m_reg.getStudents(), a_deletedStudent);
    }
}
