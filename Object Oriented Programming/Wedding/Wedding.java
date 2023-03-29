public class Wedding{
    protected String dayOfWeek, nameOfMonth, day, timeOfDay, location;
    protected Couple c = new Couple();

    //constructors
    public Wedding(String dayOfWeek, String nameOfMonth, String day, String timeOfDay, String location){
        this.dayOfWeek = dayOfWeek;
        this.nameOfMonth = nameOfMonth;
        this.day = day;
        this.timeOfDay = timeOfDay;
        this.location = location;
    }
    
    public Wedding(String dayOfWeek, String nameOfMonth, String day, String timeOfDay){
        this.dayOfWeek = dayOfWeek;
        this.nameOfMonth = nameOfMonth;
        this.day = day;
        this.timeOfDay = timeOfDay;
    }

    public Wedding(String location){
        this.location = location;
    }
    
    public Wedding(){}

    //setters
    public void setWeddingDate(){
        System.out.print("\n--Wedding Date--\n\nEnter day of the week: ");
        dayOfWeek = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter name of month: ");
        nameOfMonth = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter day: ");
        day = new java.util.Scanner(System.in).nextLine();
        System.out.print("Enter time of day: ");
        timeOfDay = new java.util.Scanner(System.in).nextLine();
    }

    public void setCoupleNames(){
        c.setGroomName();c.setBrideName();
    }

    public void setWeddingLocation(){
        System.out.print("\nEnter wedding location: ");
        location = new java.util.Scanner(System.in).nextLine();
    }

    //getters
    public String getWeddingLocation(){ return location; }
    public String getWeddingDate(){ return dayOfWeek + ", " + nameOfMonth + " " + day + "\nat " + timeOfDay; }
    public String getCoupleNames(){
        return "Mr " + c.getGroomName() + " and " + "Miss " + c.getBrideName();
    }
}
