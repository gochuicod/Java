/**
    Darelle Gochuico, BSIT - 2
    Semifinal Programming Exercise #3

    CollegeEmployee - CollegeEmployee descends from Person.  A CollegeEmployee also includes a 
    Social Security number, an annual salary, and a department name, as well as methods that 
    override the Person methods to accept and display all CollegeEmployee data.
*/
import javax.swing.*;

public class CollegeEmployee extends Person{
     private long socialSecurityNumber, salary;
     private String departmentName;

     //constructors
     public CollegeEmployee(String firstName, String lastName, String streetAddress, long zipCode, String phoneNumber, long socialSecurityNumber, long salary, String departmentName){
         super(firstName, lastName, streetAddress, zipCode, phoneNumber);
         this.socialSecurityNumber = socialSecurityNumber; this.salary = salary;
         this.departmentName = departmentName;
     }

     public CollegeEmployee(long socialSecurityNumber, long salary, String departmentName){
         this.socialSecurityNumber = socialSecurityNumber; this.salary = salary;
         this.departmentName = departmentName;
     }
     //default
     public CollegeEmployee(){}

     //setters
     public void setSocialSecurityNumber(long socialSecurityNumber){}
     public void setSalary(long salary){}
     public void setDepartmentName(String departmentName){}

     //getters
     public long getSocialSecurityNumber(){ return socialSecurityNumber; }
     public long getSalary(){ return salary; }
     public String getDepartmentName(){ return departmentName; }

    //operation
    public void setCollegeEmployee(){
        super.setPerson();
        frame = new JFrame();
        String SSNumber = JOptionPane.showInputDialog(frame,"Enter Social Security Number");
        String Salary = JOptionPane.showInputDialog(frame,"Enter Salary");
        String departmentName = JOptionPane.showInputDialog(frame,"Enter Department Name");
        long socialSecurityNumber = Long.parseLong(SSNumber);
        long salary = Long.parseLong(Salary);
        this.socialSecurityNumber = socialSecurityNumber; this.salary = salary; this.departmentName = departmentName;
    }
}
