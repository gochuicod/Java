/*
Darelle Gochuico
BSIT - 2
OOPROG21 Semifinal Activity#1

 Allow the user to enter numbers or elements. Create  methods to generate the following results:
 1. smallest number
 2. largest number
 3. sum of all elements
 4. display all even elements
 5. display all odd elements
 6. average of the elements
*/

import java.util.Scanner;

public class Mathematician{
    public static void main(String [] args){
        System.out.print("How many elements would you like to enter:");
        int size = console.nextInt();
        int [] list = getElements(size);
        display(list);
        System.out.println("Smallest Number: " + getSmallestNumber(list));
        System.out.println("Largest Number: " + getLargestNumber(list));
        System.out.println("Sum: " + getSum(list));
        displayEven(list);
        System.out.print("\n");
        displayOdd(list);
        System.out.println("\nAverage: " + getAverage(list));
    }

    static Scanner console = new Scanner(System.in);
 
    public static int getElement(){
        return console.nextInt();
    }
 
    public static int [] getElements(int size){
        int [] list = new int[size];
        System.out.println("Enter " +size+ " elements:");
        for(int i = 0; i < list.length; i++){
            System.out.print(i+1+".) ");
            list[i] = getElement();
        }
            return list;
    }

 
    public static int getSum(int [] list){
        int sum = 0;
        for(int index:list)
            sum = sum + index;
        return sum;
    }
 
    public static double getAverage(int [] list){
        return (double)getSum(list)/list.length;
    }

    public static int getSmallestNumber(int [] list){
        int smallest = list[0];
        for(int i = 1; i < list.length; i++){
            if(smallest > list[i]){
                smallest = list[i];
            }
        }
        return smallest;
    }

    public static int getLargestNumber(int [] list){
        int largest = list[0];
        for(int i = 0; i < list.length; i++){
            if(largest < list[i]){
                largest = list[i];
            }
        }
        return largest;
    }

    public static void displayEven(int [] list){
        System.out.print("Even numbers: ");
        for(int i = 0; i < list.length; i++){
            if(list[i] % 2 == 0)
                System.out.print(list[i] + " ");
        }
    }

    public static void displayOdd(int [] list){
        System.out.print("Odd numbers: ");
        for(int i = 0; i < list.length; i++){
            if(list[i] % 2 != 0)
                System.out.print(list[i] + " ");
        }
    }
 
     
    public static void display(int [] list){
        System.out.print("Elements are: ");
        //for(int i = 0; i < list.length; i++)
        // System.out.print(list[i] + "  ");
            for(int value:list)
            System.out.print(value + " ");
            System.out.println();
     }
}//end of class
