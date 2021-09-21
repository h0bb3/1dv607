package model;

public class NEString {
    private String m_s;

    public NEString(String a_s) {
        if (a_s == null || a_s.isEmpty()) {
            throw new IllegalArgumentException("String is null or empty");
        }
        m_s = a_s;
    }

    public String str() {
        return m_s;
    }

    @Override
    public String toString() {
      return str();
    } 

    public boolean equals(Object a_obj) {
        if (this == a_obj) {
            return true;
        }
        if (a_obj instanceof NEString) {
            NEString obj = (NEString)a_obj;
            return obj.m_s.equals(this.m_s);
        }

        return false;
    }
}
