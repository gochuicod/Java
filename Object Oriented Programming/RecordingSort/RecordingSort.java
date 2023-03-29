/**
    Name: Darelle Gochuico
    Course: BSIT - 2
    Semifinal Programming Exercise #2
*/

public class RecordingSort{
    public static void main(String[] args){
        int option;
        do{
            System.out.print(menu);
            option = new java.util.Scanner(System.in).nextInt();
            switch(option){
                case 0:
                    return;
                case 1:
                    userInput();
                    break;
                case 2:
                    try{
                        System.out.print(case2);
                        int choice = new java.util.Scanner(System.in).nextInt();
                        sortRecordings(choice);
                    }catch(Exception e){ System.out.println("\nInvalid Option"); };
                    break;
                case 3:
                    displayRecordings();
                    break;
                default:
                    System.out.println("\nInvalid Option");
            }
        }while(option != 0);
    }

    //My defined values
    protected static Recording[] recordings = new Recording[50];
    protected static String title, artist;
    protected static int tail;
    protected static final String menu = "\nPress 1 to add a record, 2 to sort records, 3 to display records, 0 to exit\nOption: ";
    protected static final String case2 = "\nSort options: 1 for title, 2 for artist, 3 for playing time\nOption: ";

    public static boolean isFull(){ return recordings.length == tail; }

    public static boolean userInput(){
        boolean ok = !isFull();
        if(ok)
            System.out.print("Enter title: ");
            String title = new java.util.Scanner(System.in).nextLine();
            System.out.print("Enter artist: ");
            String artist = new java.util.Scanner(System.in).nextLine();
            System.out.print("Enter playing time(in seconds): ");
            int seconds = new java.util.Scanner(System.in).nextInt();
            recordings[tail++] = new Recording(title,artist,seconds);
        return ok;
    }

    public static void sortRecordings(int option){
        switch(option){
            case 1:
                sortByTitle();
                break;
            case 2:
                sortByArtist();
                break;
            case 3:
                sortByTime();
                break;
            default:
                System.out.println("\nInvalid Input");
        }
    }

    public static void sortByTitle(){
        for(int i = 0; i < tail; i++){
            Recording key = recordings[i];
            int j = i - 1;
            for(;j >= 0 && (recordings[j].getTitle().compareTo(key.getTitle()) > 0);){
                recordings[j + 1] = recordings[j];
                j -= 1;
            }
            recordings[j + 1] = key;
        }
    }
    
    public static void sortByArtist(){
        for(int i = 0; i < tail; i++){
            Recording key = recordings[i];
            int j = i - 1;
            for(;j >= 0 && (recordings[j].getArtist().compareTo(key.getArtist()) > 0);){
                recordings[j + 1] = recordings[j];
                j -= 1;
            }
            recordings[j + 1] = key;
        }
    }

    public static void sortByTime(){
        for(int i = 0; i < tail; i++){
            Recording key = recordings[i];
            int j = i - 1;
            for(;j >= 0 && (recordings[j].getSeconds() < key.getSeconds());){
                recordings[j + 1] = recordings[j];
                j -= 1;
            }
            recordings[j + 1] = key;
        }
    }

    public static void displayRecordings(){
        for(int i = 0; i < tail; i++){
            System.out.println(recordings[i].getTitle() + " - " + recordings[i].getArtist() + ", " + recordings[i].getSeconds() + " seconds");
        }
    }
}//end of class
