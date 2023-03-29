/**
    Name: Darelle Gochuico
    Course: BSIT - 2
    Semifinal Programming Exercise #2

    Problem: 
    Radio station JAVA wants a class to keep track of recordings it plays. 
    Create a class named Recording that contains fields to hold methods for 
    setting and getting a Recording’s title, artist, and playing time in seconds. 
    Save the file as Recording.java. Write an application that instantiates five 
    Recording objects and prompts the user for values for the data fields. 
    Then prompt the user to enter which field the Recordings should 
    be sorted by - song title, artist, or playing time. 
    Perform the requested sort procedure, and display the Recording objects. 
    Save the file as RecordingSort.java 
*/

public class Recording{
    protected String title, artist;
    protected int seconds;

    //default constructor
    public Recording(String title, String artist, int seconds){
        this.title = title; this.artist = artist; this.seconds = seconds;
    }
    public Recording(){ title = ""; artist = ""; seconds = 0; }

    //setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    //getters
    public String getTitle(){ return title; }
    public String getArtist(){ return artist; }
    public int getSeconds(){ return seconds; }
}
