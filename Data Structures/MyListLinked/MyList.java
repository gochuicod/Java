public interface MyList{
    //sentinels
    public boolean isFull();
    public boolean isEmpty();

    //utility methods
    public boolean addItem(Object item);
    public boolean isItem(Object item);
    public boolean deleteItem(Object item);
    public boolean replaceItem(Object item, Object newitem);
    public boolean insertBefore(Object item, Object newitem);
    public boolean insertAfter(Object item, Object newitem);
    public void clear();
}//end of class
