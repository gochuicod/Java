/*
Name: Darelle Gochuico
BSIT - 2
OOPROG21

Create a class Person with the following attributes:
-   lastname : String
-   firstname: String
-   gender: char
Create the appropriate constructors, setters and getters
Create 3 objects of the Person class
*/

public class Person{
    private String lastname, firstname;
    private char gender;

    public static void main(String[] args){
        //Person 1
        Person p1 = new Person();
        System.out.print("Enter your first name: ");
        String firstName1 = new java.util.Scanner(System.in).nextLine();
        p1.setFirstName(firstName1);
        System.out.print("Enter your last name: ");
        String lastName1 = new java.util.Scanner(System.in).nextLine();
        p1.setLastName(lastName1);
        System.out.print("Enter Gender(M/F): ");
        char Gender1 = new java.util.Scanner(System.in).next().toUpperCase().charAt(0);
        p1.setGender(Gender1);
        p1.displayFullName();
        p1.displayGender();

        //Person 2
        Person p2 = new Person("Doe", "Jane", 'F');
        System.out.print("\n"); 
        p2.displayFullName();
        p2.displayGender();

        //Person 3
        System.out.print("\nEnter your first name: ");
        String firstname2 = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter your last name: ");
        String lastname2 = new java.util.Scanner(System.in).nextLine();
        System.out.print("Gender(M/F): ");
        char Gender2 = new java.util.Scanner(System.in).next().toUpperCase().charAt(0);
        Person p3 = new Person(lastname2,firstname2,Gender2);
        p3.displayFullName();
        p3.displayGender();

    }

    //constructors
    public Person(String lastname, String firstname, char gender){
        this.lastname = lastname;
        this.firstname = firstname;
        this.gender = gender;
    }

    public Person(){}

    //setters
    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    //getters
    public String getLastName(){ return lastname; }
    public String getFirstName(){ return firstname; }
    public char getGender(){ return gender; }

    //displays
    public void displayFullName(){
        System.out.print("First name: " + firstname + "\nLast name: " + lastname);
    }

    public void displayGender(){
        if(gender == 'M')
            System.out.print("\nGender: Male");
        else if(gender == 'F')
            System.out.print("\nGender: Female");
        else
            System.out.print("\nGender: N/A");
    }
}// end of class
