// Name: Darelle Gochuico
// BSIT - 2
// OOPROG21

// Prelim - Programming ExerciseNo3
// In a right triangle, the square of the length of one side is equal to the sum of the 
// squares of the lengths of the other two sides. Write a program that prompts the user to 
// enter the lengths of three sides of a triangle and then outputs a message indicating 
// whether the triangle is a right triangle.

import java.lang.*; import java.lang.Math;

public class Exercise3{
    public static void main(String... args){
        char choice; System.out.print("TIP: You might want to try putting 6,8,10; 5,4,3; 15,9,12, as these result to a right triangle\n");
        do{
            System.out.print("\nLength of side A: "); double side_a = new java.util.Scanner(System.in).nextDouble();
            System.out.print("Length of side B: "); double side_b = new java.util.Scanner(System.in).nextDouble();
            System.out.print("Length of side C: "); double side_c = new java.util.Scanner(System.in).nextDouble();
            if (((Math.pow(side_a,2)) == (Math.pow(side_b,2) + Math.pow(side_c,2))) || ((Math.pow(side_b,2)) == (Math.pow(side_a,2) + Math.pow(side_c,2))) 
            || ((Math.pow(side_c,2)) == (Math.pow(side_b,2) + Math.pow(side_a,2)))) {
                System.out.println("\nIt is a right triangle!");
            } else {
                System.out.println("\nUnknown triangle");
            }
            System.out.print("\nStart again?(y/n): ");
            choice = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        }while(choice == 'y');
    }// end of main
}//end of class