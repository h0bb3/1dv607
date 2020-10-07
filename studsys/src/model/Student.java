package model;

public class Student {
    NEString m_name;
    EmailAddress m_email;

    public Student(NEString a_name, EmailAddress a_email) {
        m_name = a_name;
        m_email = a_email.clone();
    }

    public NEString getName() {
        return m_name;
    }

    public final EmailAddress getEmail() {
        return m_email;
    }
}
