/*
Name: Darelle Gochuico
BSIT - 2
OOPROG21 - Programming Exercise 5

Write an application that accepts a word from a user and converts it to Pig Latin. If a word starts with a consonant,
the Pig Latin version removes all consonants from the beginning of the word and places them at the end, followed by ay.
For example, cricket becomes icketcray. If a word starts with a vowel, the Pig Latin version is the original word with 
ay added to the end. For example, apple becomes appleay. If y is the  first letter in a word, it is treated as a consonant; 
otherwise, it is treated as a vowel. For example, young becomes oungyay, but system becomes ystemsay. For this program, 
assume that the user will enter only a single word consisting of all lowercase letters. Save the file as PigLatin.java.
*/

public class PigLatin{
    public static void main(String[] args){
        String word;
        char session;
        do{
            System.out.print("\nEnter a word: ");
            word = new java.util.Scanner(System.in).nextLine();
            long startTime = System.currentTimeMillis();
            System.out.print("\nPig Latin: " + convertWord(word.toLowerCase()));
            long endTime = System.currentTimeMillis();
            System.out.println("\n\nTime of conversion in Milli seconds: " + (endTime - startTime));
            System.out.print("\nRun again?(y/n): ");
            session = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        }while(session == 'y');
    }//end of main

    //create StringBuilder method that converts a word into its Pig Latin equivalent
    public static StringBuilder convertWord(String word){
        StringBuilder sb = new StringBuilder(word);
        if(!isEmpty(sb))
            for(int i = 0; i < word.length();){
                if(!isVowel(word.charAt(i),i)){
                    sb.append(word.charAt(i));
                    sb.deleteCharAt(0);
                    i++;
                } else break;
            }
        return sb.append("ay");
    }

     public static Boolean isVowel(char c, int index){
        return (index > 0 && (c == 'y')) ? true : ((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? true : false);
     }

     public static Boolean isEmpty(StringBuilder sb){
        return (sb == null) ? true : false;
     }
}//end of class
