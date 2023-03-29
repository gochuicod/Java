public class Main{
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
    }// end of main
}// end of class
