/**
   Darelle Gochuico
   BSIT-2
   data struct 21

   A program that would accept 10 integers, that ranges from 1 to 100,
   Be able to count how numbers are in the range 1-25, 26-50,51-75,76-100.
   Thereafter, display the result.
*/

import java.util.*;

public class Program1{
   static public void main(String... args){
      int i,range1 = 0,range2 = 0,range3 = 0,range4 = 0;
         for(i = 0; i < 10;){
            try{
               System.out.print("Enter a number: ");
               int num = new java.util.Scanner(System.in).nextInt();
               if(num < 1 || num > 100){ System.out.print("\nInvalid input!\n\n"); } else { i+=0; }
               if (num > 0 && num < 26){ 
                  range1++; i++;
               } else if (num > 25 && num < 51){ 
                  range2++; i++;
               } else if (num > 50 && num < 76){ 
                  range3++; i++;
               } else if (num > 75 && num < 101){ 
                  range4++; i++;
               } else { 
                  i+=0;
               }
            }catch(Exception e){ System.out.print("\nInvalid input!\n\n"); }
         }
                  System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                  System.out.print("In ranges 1-25 there are " + range1 + " number(s)\n");
                  System.out.print("In ranges 26-50 there are " + range2 + " number(s)\n");
                  System.out.print("In ranges 51-75 there are " + range3 + " number(s)\n");
                  System.out.print("In ranges 76-100 there are " + range4 + " number(s)\n");
                  System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
   }
}//end of class
