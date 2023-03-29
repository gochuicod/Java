/**
    Darelle Gochuico, BSIT - 2
    Semifinal Programming Exercise #3
    
    Faculty - Faculty descends from CollegeEmployee. This class also includes a Boolean field that
    indicates whether the Faculty member is tenured, as well as methods that override the 
    CollegeEmployee methods to accept and display this additional piece of information. 
*/

import javax.swing.*;

public class Faculty extends CollegeEmployee{
    private boolean tenured;

    //constructors
    public Faculty(String firstName, String lastName, String streetAddress, long zipCode, String phoneNumber, long socialSecurityNumber, long salary, String departmentName, boolean tenured){
        super(firstName, lastName, streetAddress, zipCode, phoneNumber, socialSecurityNumber, salary, departmentName);
        this.tenured = tenured;
    }

    //default
    public Faculty(){}

    //setters
    public void isTenured(boolean YES_OR_NO){
        this.tenured = YES_OR_NO;
    }

    //getters
    public String getTenureStatus(){ return (tenured == true) ? "Tenured" : "Not Tenured"; }

    //operation
    public void setFaculty(){
        super.setCollegeEmployee();
        frame = new JFrame();
        int tenured_or_not = JOptionPane.showConfirmDialog(null, "Is this faculty member tenured. YES or NO?", "Select an option",JOptionPane.YES_NO_OPTION);
        tenured = tenured_or_not == JOptionPane.YES_OPTION;
        this.tenured = tenured;
    }
}
