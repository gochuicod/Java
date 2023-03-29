/**
   Darelle Gochuico
   BSIT-2
   data struct 21

   Input letter grade and display the corresponding remarks
   Letter      Remarks
     A         "Excellent"
     B         "Very Good"
     C         "Satisfactory"
     D         "Needs Improvement"
     E         "Failed"
*/
public class Program2{
   static public void main(String... args){
       System.out.print("Enter letter of Grade: "); char letter_grade = new java.util.Scanner(System.in).next().charAt(0);
       switch(letter_grade){
            case 'A':
                System.out.print("Excellent"); break;
            case 'B':
                System.out.print("Very Good"); break; 
            case 'C':
                System.out.print("Satisfactory"); break; 
            case 'D':
                System.out.print("Needs Improvement"); break; 
            case 'E':
                System.out.print("Failed"); break; 
            default:
                System.out.print("Invalid Input!");
       }
   }
}//end of class