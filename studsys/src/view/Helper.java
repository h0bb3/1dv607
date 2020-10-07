package view;

import model.EmailAddress;
import model.NEString;

public class Helper {
    public String toString(model.EmailAddress a_email) {
        String domain = "";

        for(NEString s : a_email.getDomainParts()) {
            domain += s.str() + ".";
        }

        domain = domain.substring(0, domain.length() - 1);

        return a_email.getUserName().str() + "@" + domain;
    }

    public EmailAddress toEmailAddress(String a_email) {
        String [] emailParts = a_email.split("@");

        if (emailParts.length != 2) {
            throw new IllegalArgumentException("Not a valid email address string: " + a_email);
        }

        String [] domainParts = emailParts[1].split("\\.");

        if (domainParts.length < 2) {
            throw new IllegalArgumentException("Not a valid email address string: " + a_email);
        }

        NEString [] dParts = new NEString[domainParts.length];
        for (int i = 0; i < dParts.length; i++) {
            dParts[i] = new NEString(domainParts[i]);
        }

        return new EmailAddress(new NEString(emailParts[0]), dParts);
    }
}
