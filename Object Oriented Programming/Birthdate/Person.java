/**
Name: Darelle Gochuico
BSIT - 2
OOPROG21 - Midterm Programming Exercise 3

Create a class Person with the following attributes:
-	lastname : String
-	firstname: String
-	gender: char
-  birthdate: Birthdate
Create the appropriate constructors, setters and getters
Create 3 objects of the Person class*/

import java.time.LocalDate;
import java.time.DayOfWeek;

public class Person{
    protected String firstName, lastName;
    protected int age, year, month, day;
    protected char gender;
    protected LocalDate birthdate;

    //constructors
    public Person(String firstName, String lastName, char gender, int year, int month, int day){
        this.firstName = firstName; this.lastName = lastName; this.gender = gender;
        birthdate = LocalDate.of(year,month,day);
    }

    public Person(){}

    //setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public void setBirthdate(int year, int month, int day){
        this.year = year; this.month = month; this.day = day;
        birthdate = LocalDate.of(year,month,day);
    }

    //getters
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getGender(){ return ((gender == 'M') ? "Male" : ((gender == 'F') ? "Female" : "Other"));  }
    public int getAge(){
        LocalDate current_time = LocalDate.now();
        int current_month = current_time.getMonthValue(); 
        int current_year = current_time.getYear();
        return (current_month != month) ? (age = current_year - year - 1) : (age = current_year - year);
    }
    public LocalDate getBirthdate(){ return birthdate; }
    public String getZodiac(){
        if((month == 1 && (day > 19 && day < 31)) || (month == 2 && (day > 0 && day <= 18))){
            return "Aquarius";
        } else if((month == 2 && (day > 18 && day <= 28)) || (month == 3 && (day > 0 && day <= 20))){
            return "Pisces";
        } else if((month == 3 && (day > 20 && day <= 31)) || (month == 4 && (day > 0 && day <= 19))){
            return "Aries";
        } else if((month == 4 && (day > 19 && day <= 30)) || (month == 5 && (day > 0 && day <= 20))){
            return "Taurus";
        } else if((month == 5 && (day > 20 && day <= 31)) || (month == 6 && (day > 0 && day <= 20))){
            return "Gemini";
        } else if((month == 6 && (day > 20 && day <= 30)) || (month == 7 && (day > 0 && day <= 22))){
            return "Cancer";
        } else if((month == 7 && (day > 22 && day <= 31)) || (month == 8 && (day > 0 && day <= 22))){
            return "Leo";
        } else if((month == 8 && (day > 22 && day <= 31)) || (month == 9 && (day > 0 && day <= 22))){
            return "Virgo";
        } else if((month == 9 && (day > 22 && day <= 30)) || (month == 10 && (day > 0 && day <= 22))){
            return "Libra";
        } else if((month == 10 && (day > 22 && day <= 31)) || (month == 11 && (day > 0 && day <= 21))){
            return "Scorpio";
        } else if((month == 11 && (day > 21 && day <= 30)) || (month == 12 && (day > 0 && day <= 21))){
            return "Saggitarius";
        } else if((month == 12 && (day > 21 && day <= 31)) || (month == 1 && (day > 0 && day <= 19))){
            return "Capricorn";
        } else {
            return "You're not part of the cosmos";
        }
    }
}//end of class
