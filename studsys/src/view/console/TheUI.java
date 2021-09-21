package view.console;

import model.Student;
import view.AdminOption;
import view.Helper;
import view.IUI;
import view.StudentOption;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import static java.awt.event.KeyEvent.*;

public class TheUI implements IUI {

    private String m_name, m_email;


    public TheUI() {
        m_name = m_email = "";
    }



    public boolean showStudentForm(Student a_selectedStudent) {
        clearScreen();
        Helper h = new Helper();
        
        if (a_selectedStudent == null) {
            System.out.println("Add New Student!");
        } else {
            System.out.println("Change Student: " + a_selectedStudent.getName() + " (" + h.toString(a_selectedStudent.getEmail()) +")");
        }

        m_name = promptFor("Name: ", a_selectedStudent == null ? null : a_selectedStudent.getName().str());
        m_email = promptFor("Email: ", a_selectedStudent == null ? null : h.toString(a_selectedStudent.getEmail()));

        return m_name.length() > 0 && m_email.length() > 0;
    }



    public String promptFor(String a_info, String a_defaultValue) {
        System.out.print(a_info);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, "Cp850")); // This is probably windows console specific to handle öäå
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (a_defaultValue != null) {
            try {
                Secretary s = new Secretary();
                s.type(a_defaultValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public String getName() {
        return m_name;
    }

    public String getEmail() {
        return m_email;
    }

    private void clearScreen() {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public void showAddedStudentConfirmation(Student a_s) {
        clearScreen();
        Helper h = new Helper();
        System.out.println("Student Was Added!");
        System.out.println("Name: " + a_s.getName().str());
        System.out.println("Email: " + h.toString(a_s.getEmail()));
    }

    public model.Student showStudentList(Iterable<Student> a_students) {
        clearScreen();
        System.out.println("All Students:");
        Helper h = new Helper();
        int ix = 0;
        for (Student s : a_students) {
            System.out.println("" + ix + ". \t" + s.getName().str() + " : " + h.toString(s.getEmail()));
            ix++;
        }

        String ixStr = promptFor("Enter no. to select student or empty  to return to admin menu: ", null);
        try {
            int ixInt = Integer.parseInt(ixStr);
            ix = 0;
            for (Student s : a_students) {
                if (ix == ixInt) {
                    return s;
                }
                ix++;
            }

        } catch (NumberFormatException e) {

        }

        return null;
    }

    @Override
    public AdminOption getAdminOptions() {

        AdminOption validChoice = null;

        while (validChoice == null) {
            clearScreen();
            System.out.println("Admin Menu");
            System.out.println("1 - Add New Student");
            System.out.println("2 - List All Students");
            System.out.println("q - Quit");
            String c = promptFor("Choice: ", null);

            if (c.equalsIgnoreCase("q")) {
                validChoice = AdminOption.Quit;
            } else if (c.equalsIgnoreCase("1")) {
                validChoice = AdminOption.AddNewStudent;
            } else if (c.equalsIgnoreCase("2")) {
                validChoice = AdminOption.ListAllStudents;
            }
        }

        return validChoice;
    }

    @Override
    public StudentOption getStudentOptions(model.Student a_selectedStudent) {
        StudentOption validChoice = null;
        Helper h = new Helper();

        while (validChoice == null) {
            clearScreen();
            System.out.println("Student: " + a_selectedStudent.getName() + " (" + h.toString(a_selectedStudent.getEmail()) + ") is selected.");
            System.out.println("1 - Delete");
            System.out.println("2 - Change");
            System.out.println("r - Return");
            String c = promptFor("Choice: ", null);

            if (c.equalsIgnoreCase("r")) {
                validChoice = StudentOption.None;
            } else if (c.equalsIgnoreCase("1")) {
                validChoice = StudentOption.Delete;
            } else if (c.equalsIgnoreCase("2")) {
                validChoice = StudentOption.Change;
            }
        }

        return validChoice;
    }

    @Override
    public void onAddNewStudent(Iterable<Student> a_allStudents, Student a_newStudent) {
        // This is the console... so do nothing
    }

    @Override
    public void onDeleteStudent(Iterable<Student> students, Student a_deletedStudent) {

    }

    @Override
    public void onChangeActiveStudent(Student a_newStudent) {

    }
}
