package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Registry {

    public static interface IEventListener {
        void onAddNewStudent(Iterable<Student> a_allStudents, Student a_student);
        void onChangeStudent(Student a_oldStudent, Student a_newStudent);
        void onDeleteStudent(Student a_deletedStudent);
    }

    ArrayList<Student> m_students = new ArrayList<>();
    Set<IEventListener> m_eventListeners = new HashSet<>();

    public void addEventListener(IEventListener a_listener) {
        m_eventListeners.add(a_listener);
    }

    public void removeEventListener(IEventListener a_listener) {
        m_eventListeners.remove(a_listener);
    }

    public Student addNewStudent(String a_name, String a_email) {
        Student s = new Student(a_name, a_email);
        m_students.add(s);

        m_eventListeners.forEach(el -> el.onAddNewStudent(getStudents(), s));

        return s;
    }

    public Iterable<Student> getStudents() {
        return m_students;
    }

    public Student change(Student a_selectedStudent, String a_newName, String a_newEmail) {
        remove(a_selectedStudent);
        Student newStudent =  addNewStudent(a_newName, a_newEmail);

        m_eventListeners.forEach(el -> el.onChangeStudent(a_selectedStudent, newStudent));

        return newStudent;
    }

    public void remove(Student a_selectedStudent) {
        m_students.removeIf( student -> student.getEmail().equalsIgnoreCase(a_selectedStudent.getEmail()));

        m_eventListeners.forEach(el -> el.onDeleteStudent(a_selectedStudent));
    }
}
