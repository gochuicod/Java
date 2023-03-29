import java.time.*;

public class Person{
    protected String firstName, lastName;
    protected LocalDate localDate;
    protected int year, month, day;

    //constructors
    public Person(String firstName, String lastName, int year, int month, int day){
        this.firstName = firstName;
        this.lastName = lastName;
        localDate = LocalDate.of(year,month,day);
    }
    
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int year, int month, int day){
        localDate = LocalDate.of(year,month,day);
    }

    public Person(){}

    //setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setLocalDate(int year, int month, int day){
        localDate = LocalDate.of(year,month,day);
    }

    //getters
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public LocalDate getLocalDate(){ return localDate; }
}//end of class
