/**
   GOCHUICO, Darelle BSIT-2
   Data Struct21
   3:00-5:30 MW

   A program that would accept an integer which represents an option 
   in the menu.
   Provide necessary prompts, messages, conversion and validation
   
   Main Menu
   --------------------------------------------
   1. Accept two(2) positive integers (1->10)
   2. Compute the sum of inputted integers
   3. Compute the product of inputted integers
   4. Compute the quotient of inputted integers(real)
   5. Compute the difference of inputted integers
   0. Quit
   --------------------------------------------
   Enter Option(0..5):    
*/

public class Program3{
    static public void main(String[] args){
        boolean main_menu_option = false; int sum = 0, product = 0, quotient = 0, difference = 0, num1 = 0, num2 = 0, i;
        System.out.println("\nMain Menu\n--------------------------------------------\n1. Accept two(2) positive integers (1->10)");
        System.out.println("2. Compute the sum of inputted integers\n3. Compute the product of inputted integers");
        System.out.println("4. Compute the quotient of inputted integers(real)\n5. Compute the difference of inputted integers\n0. Quit");
        System.out.println("--------------------------------------------");
        do{
            try{
                System.out.print("\nEnter Option(0-5): "); int menu_choice = new java.util.Scanner(System.in).nextInt();
                switch(menu_choice){
                    case 1:
                        try{
                            System.out.print("Enter #1: "); num1 = new java.util.Scanner(System.in).nextInt();
                            System.out.print("Enter #2: "); num2 = new java.util.Scanner(System.in).nextInt();
                            if ((num1 < 1 || num2 < 1) || (num1 > 10 || num2 > 10)){ System.out.print("Does not meet requirements\n"); num1 = 0; num2 = 0; }
                        }catch(Exception e){ System.out.print("Does not meet requirements\n"); num1 = 0; num2 = 0; }
                        break;
                    case 2:
                        sum = num1 + num2; System.out.print("Sum: " + sum);
                        break;
                    case 3:
                        product = num1 * num2; System.out.print("Product: " + product);
                        break;
                    case 4:
                        quotient = num1 / num2; System.out.print("Quotient: " + quotient);
                        break;
                    case 5:
                        difference = num1 - num2; System.out.print("Difference: " + difference);
                        break;
                    case 0:
                        System.out.print("\nProgram Terminated\n"); main_menu_option = true;
                        break;
                    default:
                        System.out.print("Invalid Choice!\n");
                }// end of switch
            }catch(Exception e){ System.out.print("Invalid Choice!\n"); } // end of trycatch
        }while(main_menu_option == false); //end of loop
    }//end of main
}//end of class
