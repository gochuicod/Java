import java.time.*;

public class Couple{
    protected Person p1 = new Person(), p2 = new Person();

    //constructors
    public Couple(String groomFirstName, String groomLastName, String brideFirstName, String brideLastName){
        p1.setFirstName(groomFirstName); p1.setLastName(groomLastName);
        p2.setFirstName(brideFirstName); p2.setLastName(brideLastName);
    }

    public Couple(int year, int month, int day){

    }

    public Couple(){}
    
    //setters
    public void setGroomName(){
        System.out.print("\nEnter groom first name: ");
        String firstname = new java.util.Scanner(System.in).nextLine();
        p1.setFirstName(firstname);
        System.out.print("Enter groom last name: ");
        String lastname = new java.util.Scanner(System.in).nextLine();
        p1.setLastName(lastname);
    }

    public void setGroomBirthdate(){
        System.out.print("\nGroom's Birthdate\n\nEnter year: ");
        int year = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter month: ");
        int month = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter day: ");
        int day = new java.util.Scanner(System.in).nextInt();
        p1.setLocalDate(year,month,day);
    }

    public void setBrideName(){
        System.out.print("\nEnter bride first name: ");
        String firstname = new java.util.Scanner(System.in).nextLine();
        p2.setFirstName(firstname);
        System.out.print("Enter bride last name: ");
        String lastname = new java.util.Scanner(System.in).nextLine();
        p2.setLastName(lastname);
    }

    public void setBrideBirthdate(){
        System.out.print("\nBride's Birthdate\n\nEnter year: ");
        int year = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter month: ");
        int month = new java.util.Scanner(System.in).nextInt();
        System.out.print("Enter day: ");
        int day = new java.util.Scanner(System.in).nextInt();
        p2.setLocalDate(year,month,day);
    }
    
    //getters
    public String getGroomName(){ return p1.getFirstName() + " " + p1.getLastName(); }
    public String getBrideName(){ return p2.getFirstName() + " " + p2.getLastName(); }
    public LocalDate getGroomBirthdate(){ return p1.getLocalDate(); }
    public LocalDate getBrideBirthdate(){ return p2.getLocalDate(); }
}
