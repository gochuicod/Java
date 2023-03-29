/**
    Darelle Gochuico, BSIT - 2
    Semifinal Programming Exercise #3

    Person - A person contains  a first name, last name, street address, zip code, and phone number. 
    The class also includes a method that sets each data field, using a series of dialog boxes and 
    a display method that displays all of a Person’s information on a single line at the command line on the screen. 
*/

import javax.swing.*;

public class Person{
    private String firstName, lastName, streetAddress, phoneNumber;
    private long zipCode;
    protected JFrame frame;

    //constructors
    public Person(String firstName, String lastName, String streetAddress, long zipCode, String phoneNumber){
        this.firstName = firstName; this.lastName = lastName; this.streetAddress = streetAddress;
        this.zipCode = zipCode; this.phoneNumber = phoneNumber;
    }
    //default
    public Person(){}

    //setters
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setStreetAddress(String streetAddress){ this.streetAddress = streetAddress; }
    public void setZipCode(int zipCode){ this.zipCode = zipCode; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }

    //getters
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getStreetAddress(){ return streetAddress; }
    public long getZipCode(){ return zipCode; }
    public String getPhoneNumber(){ return phoneNumber; }

    //operations
    public void setPerson(){
        frame = new JFrame();
        String firstName = JOptionPane.showInputDialog(frame,"Enter First Name");
        String lastName = JOptionPane.showInputDialog(frame,"Enter Last Name");
        String streetAddress = JOptionPane.showInputDialog(frame,"Enter Street Address");
        String zC = JOptionPane.showInputDialog(frame,"Enter Zip Code");
        String phoneNumber = JOptionPane.showInputDialog(frame,"Enter Phone Number");
        long zipCode = Long.parseLong(zC);
        this.firstName = firstName; this.lastName = lastName; this.streetAddress = streetAddress;
        this.zipCode = zipCode; this.phoneNumber = phoneNumber;
    }
}//end of class
