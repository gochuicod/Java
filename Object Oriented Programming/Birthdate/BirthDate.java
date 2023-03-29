/**
Name: Darelle Gochuico
BSIT - 2
OOPROG21 - Midterm Programming Exercise 3
*/

import java.time.*;

public class BirthDate{
    private LocalDate localDate;

    public static void main(String [] args){
        display();
    }//end of main


    //constructors
    public BirthDate(int year, int month, int day){
        localDate = LocalDate.of(year,month,day);
    }

    public BirthDate(){
        this(1999,3,16);
    }

    //setters
    public void setBirthdate(int year, int month, int day){
        localDate = LocalDate.of(year,month,day);
    }

    //getters
    public LocalDate getBirthdate(){ return localDate; }

    //display
    public static void display(){
        BirthDate birthDate = new BirthDate();
        System.out.print(birthDate.getBirthdate());
        Person person = new Person("John","Doe",'M',1999,1,21);
        System.out.print("\nName: " + person.getFirstName() + " " + person.getLastName() + "\nGender: " + person.getGender() + "\nAge: " + person.getAge() + "\nBirthdate: " + person.getBirthdate());
        person.setFirstName("Jane"); person.setLastName("Doe");
        System.out.print("\nName: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("\n" + birthDate.getBirthdate());
        birthDate.setBirthdate(1999,2,1);
        System.out.println(birthDate.getBirthdate());
        person.setBirthdate(1999,2,28);
        System.out.println(person.getZodiac());
        person.setBirthdate(1999,8,30);
        System.out.println(person.getZodiac());
        person.setBirthdate(2004,1,5);
        System.out.println(person.getZodiac());
        person.setBirthdate(2021,10,25);
        System.out.println(person.getZodiac());

        System.out.print("\n--Name--\n\nEnter first name: ");
        String firstname = new java.util.Scanner(System.in).nextLine();
        person.setFirstName(firstname);
        System.out.print("Enter last name: ");
        String lastname = new java.util.Scanner(System.in).nextLine();
        person.setLastName(lastname);
        System.out.print("Enter gender(M/F): ");
        char gender = new java.util.Scanner(System.in).next().toUpperCase().charAt(0);
        person.setGender(gender);

        System.out.print("\n--Birthday--\n\nEnter birthday month number: ");
        int month = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter birthday number: ");
        int day = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter year born: ");
        int year = new java.util.Scanner(System.in).nextInt();
        person.setBirthdate(year,month,day);
        System.out.print("\n--Full Details--\n\nFull Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.print("\nGender: " + person.getGender());
        System.out.print("\nZodiac Sign: " + person.getZodiac());
        System.out.println("\nAge: " + person.getAge());
    }

}//end of class
