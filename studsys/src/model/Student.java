package model;

public class Student {
    String m_name;
    String m_email;
    public Student(String a_name, String a_email) {
        m_name = a_name;
        m_email = a_email;
    }

    public String getName() {
        return m_name;
    }

    public String getEmail() {
        return m_email;
    }
}
