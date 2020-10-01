package view;

import model.Student;

import java.io.IOException;

public interface IUI {
    public boolean showStudentForm(Student a_selectedStudent) throws IOException;

    public String getName();

    public String getEmail();

    public void showAddedStudentConfirmation(Student a_s) throws IOException;

    public model.Student showStudentList(Iterable<Student> students) throws IOException;

    public AdminOption getAdminOptions() throws IOException;

    StudentOption getStudentOptions(model.Student a_selectedStudent) throws IOException;


    void onAddNewStudent(Iterable<Student> a_allStudents, Student a_newStudent);

    void onDeleteStudent(Iterable<Student> students, Student a_deletedStudent);

    void onChangeActiveStudent(Student a_newStudent);
}
