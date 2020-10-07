package model;

import javax.print.AttributeException;
import java.net.URL;
import java.util.Arrays;

public class EmailAddress {
    private NEString m_user; // stuff before the @
    private NEString [] m_domainParts; // stuff after the @

    public static class Exception extends IllegalArgumentException {
        public static enum Code {
            NULL_NAME, NULL_DOMAIN_PARTS, NULL_DOMAIN_PART, FEW_DOMAIN_PARTS;
        }

        Code m_code;

        public Exception(Code a_code, String a_msg) {
            super(a_msg);
            m_code = a_code;
        }

        Code getCode() {
            return m_code;
        }
    }

    public EmailAddress(NEString a_userName, NEString[] a_domainParts) {
        setUserName(a_userName);
        setDomainParts(a_domainParts);
    }

    public boolean equals(Object a_obj) {
        if (this == a_obj) {
            return true;
        } else if (a_obj instanceof EmailAddress) {
            EmailAddress obj = (EmailAddress)a_obj;

            if (obj.m_user.equals(m_user) && m_domainParts.length == obj.m_domainParts.length) {
                for (int i = 0; i < m_domainParts.length; i++) {
                    if (!m_domainParts[i].equals(obj.m_domainParts[i])) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public EmailAddress clone() {
        return new EmailAddress(m_user, m_domainParts);
    }

    public Iterable<NEString> getDomainParts() {
        return Arrays.asList(m_domainParts);
    }

    public NEString getUserName() {
        return m_user;
    }

    private void setUserName(NEString a_userName) throws Exception {
        if (a_userName == null) {
            throw new Exception(Exception.Code.NULL_NAME, "Null Argument");
        }

        m_user = a_userName;
    }

    public int getMinDomainParts() {
        return 2;
    }

    private void setDomainParts(NEString [] a_domainParts) {
        if (a_domainParts == null) {
            throw new Exception(Exception.Code.NULL_DOMAIN_PARTS, "Null Argument");
        } else if (a_domainParts.length < getMinDomainParts()) {
            throw new Exception(Exception.Code.FEW_DOMAIN_PARTS, "Null Argument");
        }

        for (int i = 0; i < a_domainParts.length; i++) {
            if (a_domainParts[i] == null) {
                throw new Exception(Exception.Code.NULL_DOMAIN_PART, "illegal null domain part: " + i);
            }
        }

        m_domainParts = Arrays.copyOf(a_domainParts, a_domainParts.length);
    }
}
