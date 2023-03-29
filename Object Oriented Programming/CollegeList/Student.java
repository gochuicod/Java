/**
    Darelle Gochuico, BSIT - 2
    Semifinal Programming Exercise #3

    Student - Student descends from Person. In addition to the fields available in Person, a 
    Student contains a major field of study and a grade point average as well as methods that
    override the Person methods to accept and display these additional facts. 
*/

import javax.swing.*;

public class Student extends Person{
    private String majorFieldOfStudy;
    private double gradePointAverae;

    //constructors
    public Student(String firstName, String lastName, String streetAddress, long zipCode, String phoneNumber, String majorFieldOfStudy, double gradePointAverage){
        super(firstName, lastName, streetAddress, zipCode, phoneNumber);
        this.majorFieldOfStudy = majorFieldOfStudy; this.gradePointAverage = gradePointAverage;
    }

    //default
    public Student(){}

    //setters
    public void setMajorFieldOfStudy(String majorFieldOfStudy){
        this.majorFieldOfStudy = majorFieldOfStudy;
    }

    public void setGradePointAverage(double gradePointAverage){
        this.gradePointAverage = gradePointAverage;
    }

    //getters
    public String getMajorFieldOfStudy(){ return majorFieldOfStudy; }
    public double getGradePointAverage(){ return gradePointAverage; }

    //operations
    public void setStudent(){
        frame = new JFrame();
        super.setPerson();
        String majorFieldOfStudy = JOptionPane.showInputDialog(frame,"Enter Major Field of Study");
        String GPA = JOptionPane.showInputDialog(frame,"Enter Grade Point Average");
        double gradePointAverage = Double.parseDouble(GPA);
        this.majorFieldOfStudy = majorFieldOfStudy; this.gradePointAverage = gradePointAverage;
    }
}
