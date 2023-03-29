public class TestWedding{
    protected static String intro = "\nYou are invited to the\n\nwedding\n\njoining the lives of\n\n", outro = "\n\nReception to follow\n\n--Additional Info--\n";
    protected static Wedding w = new Wedding();
    protected static Couple couple = new Couple();
    public static void main(String[] args){
        setWedding();
        displayWedding();

//        Person person = new Person("Darelle","Gochuico",1999,10,2);
//        System.out.print("Name: " + person.getFirstName() + " "  + person.getLastName() + "\n" + person.getLocalDate());
    }//end of main

    //setters
    public static void setWedding(){
        w.setCoupleNames();
        w.setWeddingDate();
        w.setWeddingLocation();
        setBirthdate();
    }

    public static void setBirthdate(){
        couple.setGroomBirthdate();
        couple.setBrideBirthdate();
    }

    //getters
    public static String getBirthdate(){
        return "Groom birthdate: " + couple.getGroomBirthdate() + "\nBride birthdate: " + couple.getBrideBirthdate();
    }

    //display
    public static void displayWedding(){
        System.out.print(intro.toUpperCase() + w.getCoupleNames().toUpperCase() + "\n\n" + w.getWeddingDate().toUpperCase() + "\n\n" + w.getWeddingLocation().toUpperCase() + outro.toUpperCase() + getBirthdate().toUpperCase());
    }
}//end of class
