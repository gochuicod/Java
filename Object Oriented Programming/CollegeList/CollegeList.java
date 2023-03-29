/**
    Darelle Gochuico, BSIT - 2
    Semifinal Programming Exercise #3

    Write an application named CollegeList that declares an array of four “ regular” CollegeEmployees, three Faculty, and
    seven Students. Prompt the user to specify which type of person’s data will be entered (C, F, or S), or allow the user 
    to quit (Q). While the user chooses to continue(that is, does not quit), accept data entry for the appropriate type of 
    Person. If the user attempts to enter data for more than four CollegeEmployees, three Faculty, or seven Students, 
    display an error message. When the user quits, display a report on the screen listing each group of Persons under the 
    appropriate heading of “College Employees,” “Faculty”, or “Students”. If the user has not entered data for one or more 
    types of Persons during a session, display an appropriate message under the appropriate heading. 

Save the files as Person.java, CollegeEmployee.java, Faculty.java, Student.java, and CollegeList.java. 
*/

import javax.swing.*;

public class CollegeList{
    public static void main(String[] args){
        char option, view;
        do{
            //CLI output
            // System.out.print("Type of Data(C for College Employee, F for Faculty, S for Student, Q to Quit): ");
            // option = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
            String prompt = JOptionPane.showInputDialog(frame,"C for College Employee, F for Faculty, S for Student, V for View List, Q to Quit", "Type of Data", JOptionPane.QUESTION_MESSAGE);
            option = prompt.toLowerCase().charAt(0);
            switch(option){
                case 'c':
                    if(collegecount != employee.length) setCollegeData();
                    else JOptionPane.showMessageDialog(frame, "Employee Database Full", "Warning!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 'f':
                    if(facultycount != faculty.length) setFacultyData();
                    else JOptionPane.showMessageDialog(frame, "Faculty Database Full", "Warning!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 's':
                    if(studentcount != student.length) setStudentData();
                    else JOptionPane.showMessageDialog(frame, "Student Database Full", "Warning!", JOptionPane.ERROR_MESSAGE);
                    break;
                case 'v':
                    String view_prompt = JOptionPane.showInputDialog(frame,"C to view College Employee, F for Faculty, S for Student: ");
                    view = view_prompt.charAt(0);
                    switch(view){
                        case 'c':
                            displayCollegeEmployeeData();
                            break;
                        case 'f':
                            displayFacultyData();
                            break;
                        case 's':
                            displayStudentData();
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Invalid Option", "Warning!", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 'q':
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Invalid Option", "Warning!", JOptionPane.ERROR_MESSAGE);
            }
        }while(option != 'q');
    }//end of main

    protected static CollegeEmployee[] employee = new CollegeEmployee[4];
    protected static Faculty[] faculty = new Faculty[3];
    protected static Student[] student = new Student[7];
    protected static JFrame frame;
    protected static int collegecount, facultycount, studentcount;

    public static void setCollegeData(){
            String firstName = JOptionPane.showInputDialog(frame,"Enter First Name of Employee");
            String lastName = JOptionPane.showInputDialog(frame,"Enter Last Name of Employee");
            String streetAddress = JOptionPane.showInputDialog(frame,"Enter Street Address of Employee");
            String zC = JOptionPane.showInputDialog(frame,"Enter Zip Code of Employee");
            String phoneNumber = JOptionPane.showInputDialog(frame,"Enter Phone Number of Employee");
            String SSNumber = JOptionPane.showInputDialog(frame,"Enter Social Security Number of Employee");
            String Salary = JOptionPane.showInputDialog(frame,"Enter Salary of Employee");
            String departmentName = JOptionPane.showInputDialog(frame,"Enter Department Name of Employee");
            if((firstName == null) && (lastName == null) && (streetAddress == null) && (zC == null) && (phoneNumber == null) && (SSNumber == null) && (Salary == null) && (departmentName == null)){
                JOptionPane.showMessageDialog(frame, "No Values Registered", "Warning!", JOptionPane.ERROR_MESSAGE); 
                return; 
            }
            long zipCode, socialSecurityNumber, salary;
            if(zC == null) zipCode = 0; else zipCode = Long.parseLong(zC);
            if(SSNumber == null) socialSecurityNumber = 0; else socialSecurityNumber = Long.parseLong(SSNumber);
            if(Salary == null) salary = 0; else salary = Long.parseLong(Salary);
            employee[collegecount++] = new CollegeEmployee(firstName, lastName, streetAddress, zipCode, phoneNumber, socialSecurityNumber, salary, departmentName);
    }

    public static void setFacultyData(){
            String firstName = JOptionPane.showInputDialog(frame,"Enter First Name of Faculty");
            String lastName = JOptionPane.showInputDialog(frame,"Enter Last Name of Faculty");
            String streetAddress = JOptionPane.showInputDialog(frame,"Enter Street Address of Faculty");
            String zC = JOptionPane.showInputDialog(frame,"Enter Zip Code of Faculty");
            String phoneNumber = JOptionPane.showInputDialog(frame,"Enter Phone Number of Faculty");
            String SSNumber = JOptionPane.showInputDialog(frame,"Enter Social Security Number of Faculty");
            String Salary = JOptionPane.showInputDialog(frame,"Enter Salary of Faculty");
            String departmentName = JOptionPane.showInputDialog(frame,"Enter Department Name of Faculty");
            if((firstName == null) && (lastName == null) && (streetAddress == null) && (zC == null) && (phoneNumber == null) && (SSNumber == null) && (Salary == null) && (departmentName == null)){
                JOptionPane.showMessageDialog(frame, "No Values Registered", "Warning!", JOptionPane.ERROR_MESSAGE); 
                return; 
            }
            long zipCode, socialSecurityNumber, salary; boolean tenured;
            if(zC == null) zipCode = 0; else zipCode = Long.parseLong(zC);
            if(SSNumber == null) socialSecurityNumber = 0; else socialSecurityNumber = Long.parseLong(SSNumber);
            if(Salary == null) salary = 0; else salary = Long.parseLong(Salary);
            int tenured_or_not = JOptionPane.showConfirmDialog(null, "Is this faculty member tenured. YES or NO?", "Select an option",JOptionPane.YES_NO_OPTION);
            if(tenured_or_not == JOptionPane.YES_OPTION) tenured = true; else tenured = false;
            faculty[facultycount++] = new Faculty(firstName, lastName, streetAddress, zipCode, phoneNumber, socialSecurityNumber, salary, departmentName, tenured);
    }

    public static void setStudentData(){
            String firstName = JOptionPane.showInputDialog(frame,"Enter First Name of Student");
            String lastName = JOptionPane.showInputDialog(frame,"Enter Last Name of Student");
            String streetAddress = JOptionPane.showInputDialog(frame,"Enter Street Address of Student");
            String zC = JOptionPane.showInputDialog(frame,"Enter Zip Code of Student");
            String phoneNumber = JOptionPane.showInputDialog(frame,"Enter Phone Number of Student");
            String majorFieldOfStudy = JOptionPane.showInputDialog(frame,"Enter Major Field of Study of Student");
            String GPA = JOptionPane.showInputDialog(frame,"Enter Grade Point Average of Student");
            if((firstName == null) && (lastName == null) && (streetAddress == null) && (zC == null) && (phoneNumber == null) && (majorFieldOfStudy == null) && (GPA == null)){
                JOptionPane.showMessageDialog(frame, "No Values Registered", "Warning!", JOptionPane.ERROR_MESSAGE); 
                return; 
            }
            long zipCode; double gradePointAverage;
            if(zC == null) zipCode = 0; else zipCode = Long.parseLong(zC);
            if(GPA == null) gradePointAverage = 5.0; else gradePointAverage = Double.parseDouble(GPA);
            student[studentcount++] = new Student(firstName, lastName, streetAddress, zipCode, phoneNumber, majorFieldOfStudy, gradePointAverage);
    }

    //displays
    public static void displayCollegeEmployeeData(){
        String lineSep = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try{
            //CLI output
            // for(int i = 0; i < collegecount; i++){
            //     System.out.println("\nEmployee #" + i + "\nName: " + employee[i].getFirstName() + " " + employee[i].getLastName());
            //     System.out.println("Address: " + employee[i].getStreetAddress() + " " + employee[i].getZipCode());
            //     System.out.println("Contact no. " + employee[i].getPhoneNumber() + ", " + employee[i].getSocialSecurityNumber());
            //     System.out.println("Salary: " + employee[i].getSalary() + "\nDepartment: " + employee[i].getDepartmentName());
            // }
            sb.append("College Employee Data").append(lineSep).append(lineSep);
            for(int i = 0; i < collegecount; i++){
                sb.append("Employee #" + i).append(lineSep).append("Name: " + employee[i].getFirstName() + " " + employee[i].getLastName()).append(lineSep);
                sb.append("Address: " + employee[i].getStreetAddress() + " " + employee[i].getZipCode()).append(lineSep);
                sb.append("Contact no. " + employee[i].getPhoneNumber() + ", " + employee[i].getSocialSecurityNumber()).append(lineSep);
                sb.append("Salary: " + employee[i].getSalary()).append(lineSep).append("Department: " + employee[i].getDepartmentName()).append(lineSep).append(lineSep);
            }
            JOptionPane.showMessageDialog(frame,sb.toString());
        }catch(NullPointerException e){}
    }

    public static void displayFacultyData(){
        String lineSep = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try{
            //CLI output
            // for(int i = 0; i < facultycount; i++){
            //     System.out.println("\nFaculty #" + i + "\nName: " + faculty[i].getFirstName() + " " + faculty[i].getLastName());
            //     System.out.println("Address: " + faculty[i].getStreetAddress() + " " + faculty[i].getZipCode());
            //     System.out.println("Contact no. " + faculty[i].getPhoneNumber() + ", " + faculty[i].getSocialSecurityNumber());
            //     System.out.println("Salary: " + faculty[i].getSalary() + "\nDepartment: " + faculty[i].getDepartmentName());
            //     System.out.println("Tenure Status: " + faculty[i].getTenureStatus());
            // }
            sb.append("Faculty Data").append(lineSep).append(lineSep);
            for(int i = 0; i < facultycount; i++){
                sb.append("Faculty #" + i).append(lineSep).append("Name: " + faculty[i].getFirstName() + " " + faculty[i].getLastName()).append(lineSep);
                sb.append("Address: " + faculty[i].getStreetAddress() + " " + faculty[i].getZipCode()).append(lineSep);
                sb.append("Contact no. " + faculty[i].getPhoneNumber() + ", " + faculty[i].getSocialSecurityNumber()).append(lineSep);
                sb.append("Salary: " + faculty[i].getSalary()).append(lineSep).append("Department: " + faculty[i].getDepartmentName()).append(lineSep);
                sb.append("Tenure Status: " + faculty[i].getTenureStatus()).append(lineSep).append(lineSep);
            }
            JOptionPane.showMessageDialog(frame,sb.toString());
        }catch(NullPointerException e){}
    }

    public static void displayStudentData(){
        String lineSep = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try{
            //CLI output
            // for(int i = 0; i < studentcount; i++){
            //     System.out.println("\nStudent #" + i + "\nName: " + student[i].getFirstName() + " " + student[i].getLastName());
            //     System.out.println("Address: " + student[i].getStreetAddress() + " " + student[i].getZipCode());
            //     System.out.println("Major in: " + student[i].getMajorFieldOfStudy() + ", GPA: " + student[i].getGradePointAverage());
            // }
            sb.append("Student Data").append(lineSep).append(lineSep);
            for(int i = 0; i < studentcount; i++){
                sb.append("Student #" + i).append(lineSep).append("Name: " + student[i].getFirstName() + " " + student[i].getLastName()).append(lineSep);
                sb.append("Address: " + student[i].getStreetAddress() + " " + student[i].getZipCode()).append(lineSep);
                sb.append("Major in: " + student[i].getMajorFieldOfStudy() + ", GPA: " + student[i].getGradePointAverage()).append(lineSep).append(lineSep);
            }
            JOptionPane.showMessageDialog(frame,sb.toString());
        }catch(NullPointerException e){}
    }

    public static void dataList(){
        displayCollegeEmployeeData();
        displayFacultyData();
        displayStudentData();
    }
}//end of class
