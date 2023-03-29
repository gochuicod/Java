/**
Name: Darelle Gochuico
BSIT - 2

OOProg21 - Object-Oriented Programming 
Midterm - Programming Exercise1

Problem:

Write a program that uses while loops to perform the following steps:
Prompt the user to input two integers: firstNum and secondNum. (firstNum must be less than secondNum).
Output all the odd numbers between firstNum and secondNum inclusive.
Output the sum of all the even numbers between firstNum and secondNum inclusive
Output the sum of the squares of all the even numbers between firstNum and secondNum inclusive
Output the sum of the squares of all the odd numbers between firstNum and secondNum inclusive.
*/

public class MidtermProgram1{
    private static int firstNum, secondNum; //static variable can only hold 1 value at a time
    public static void main(String[] args){
            Input();
            displayOdd();
            displayEven();
            Sum_Square_of_Even();
            Sum_Square_of_Odd();
    }//end of main

    public static void Input(){
        while(secondNum <= firstNum){
            try{
            System.out.print("\nEnter the first number: ");
            firstNum = new java.util.Scanner(System.in).nextInt();
            System.out.print("Enter the second number: ");
            secondNum = new java.util.Scanner(System.in).nextInt();
            if(firstNum > secondNum){ System.out.print("\nError. First number must be less than the second number!\n"); }
            }catch(Exception e){ System.out.print("\nError. Character inputs are invalid!\n"); }
        }
    }//end of Input

    public static void displayOdd(){
        System.out.print("\nThe odd numbers between " + firstNum + " and " + secondNum + " inclusive: "); int i = firstNum;
        while(i <= secondNum){
            if(i % 2 != 0){ System.out.print(i + " "); }
            i++;
        }
    }//end of Odd

    public static void displayEven(){
        int sum = 0, i = firstNum;
        System.out.print("\nThe even numbers between " + firstNum + " and " + secondNum + " inclusive: ");
        while(i <= secondNum){
            if(i % 2 == 0){ System.out.print(i + " "); sum +=i; }
            i++;
        }
        System.out.print("\nThe sum of even numbers between " + firstNum + " and " + secondNum + " is " + sum);
    }// end of Even

    public static void Sum_Square_of_Even(){
        int sum = 0, i = firstNum;
        System.out.print("\nThe squared even numbers between " + firstNum + " and " + secondNum + " inclusive: ");
        while(i <= secondNum){
            if((int)Math.pow(i,2) % 2 == 0) { System.out.print((int)Math.pow(i,2) + " "); sum += ((int)Math.pow(i,2)); }
            i++;
        }
        System.out.print("\nThe sum of squared even numbers is " + sum);
    }//end of Sum_Square_of_Even

    public static void Sum_Square_of_Odd(){
        int sum = 0, i = firstNum;
        System.out.print("\nThe squared odd numbers between " + firstNum + " and " + secondNum + " inclusive: ");
        while(i <= secondNum){
            if((int)Math.pow(i,2) % 2 != 0) { System.out.print((int)Math.pow(i,2) + " ");  sum += ((int)Math.pow(i,2)); }
            i++;
        }
        System.out.print("\nThe sum of squared odd numbers is " + sum);
    }//end of Sum_Square_of_Odd
}//end of class
