// Name: Darelle Gochuico
// BSIT - 2
// OOPROG21

// Prelim - Programming Exercise No. 4
// Write a program that prompts the user to input and then outputs both the individual digits of the 
// number and the sum of the digits. For example, the program should output the individual digits of 
// 3456 as 3 4 5 6 and the sum as 18, output the individual digits of 8030 as 8 0 3 0 and the sum as 11, 
// output the individual digits of  2345526 as 2 3 4 5 5 2 6 and the sum as 27, output the individual 
// digits of 4000 as 4 0 0 0 and the sum as 4, and output the individual digits of -2345 as 2 3 4 5 and the sum as 14.

import java.lang.*;

public class Exercise4{
    public static void main(String[] args){
        char choice; System.out.print("\nTIP! The program can accept a 15 digit long number");
        do{
            System.out.print("\n\nEnter any number: ");
            long n = new java.util.Scanner(System.in).nextLong(), temp, remainder = 0, sum = 0, count = 0, i;
            temp=n;
            while (temp>0)  
            {  
                remainder = temp % 10;
                sum += remainder;
                count++;  
                temp = temp/10;  
            }  

            double num = Math.pow(10, count-1); i = (long)num;

            System.out.print("\nSet of numbers: ");
            for (;i>0;i/=10){  
                System.out.print(n/i%10 + " ");  
            }
                System.out.print("\n\nSum:" + sum + "\n");
                System.out.print("\nStart again?(y/n): ");
                choice = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        }while(choice == 'y');
    }// end of main
}// end of class
