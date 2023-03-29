/*
Name: Darelle Gochuico
BSIT - 2
OOPROG21 - Programming Exercise 4

Instructions:
Three-letter acronyms are common in the business world. For example, in Java you use the IDE (Integrated Development Environment) 
in the JDK (Java Development Kit) to write programs used by the JVM (Java Virtual Machine) that you might send over a 
LAN (local area network). Programmers even use the acronym TLA to stand for three-letter acronym. Write a program that allows a 
user to enter three words, and display the appropriate three-letter acronym in all uppercase letters. If the user enters more 
than three words, ignore the extra words. Save the file as ThreeLetterAcronym.java
*/

public class ThreeeLetterAcronym{
    private static String words;
    private static StringBuffer sb;
    private static int count;
    public static void main(String[] args){
        char session;
        do{
            System.out.print("\nEnter a three word sentence: ");
            words = new java.util.Scanner(System.in).nextLine();
            convertThreeWord(words);
            System.out.print("\nAcronym: " + sb.toString().toUpperCase());
            System.out.print("\n\nRun again?(y/n): ");
            session = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
            sb.setLength(0); count = 0;
        }while(session == 'y');
    }//end of main

    public static void convertThreeWord(String words){
        sb = new StringBuffer();
        sb.append(words.charAt(0));
        for(int i = 0; i < words.length(); i++){
            if(isSpace(words.charAt(i))){
                    sb.append(words.charAt(++i));
                    count++;
            }
            if(count > 2){
                System.out.print("\nOnly accepting a maximum of three words");
                sb.delete(0,sb.toString().length());
                break;
            }
        }
    }

    public static Boolean isSpace(char c){
        return (c == ' ' || c == '-') ? true : false;
    }
}// end of class
