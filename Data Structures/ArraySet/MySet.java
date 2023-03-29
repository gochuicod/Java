/**    
    Name: Darelle Gochuico
    Subject: DASTRUC21
    EDPCode: 05173
    Schedule: Mondays and Wednesdays, 3:00 PM - 5:30 PM

    MySet
*/

public interface MySet{
    //define sentinel methods
    public boolean isFull();
    public boolean isEmpty();
    //utility methods
    public boolean isItem(Object item);
    public boolean addItem(Object item);
    public boolean deleteItem(Object item);
    public void clear();
    //allowable operations
    public MySet union(MySet paraset);
    public MySet intersect(MySet paraset);
    public MySet subtract(MySet paraset);
    public MySet crossproduct(MySet paraset);
    public int cardinality(); //return the count of the elements in a Set
}//end of class
