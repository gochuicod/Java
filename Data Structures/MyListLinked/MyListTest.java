/**
    MyList Test
*/

public class MyListTest{
    public static void main(String[] args){
        MyList list = new MyListLinked(new String[]{"a","b","c","d","e","f"});
        System.out.println("Current List: " + list);
        list.deleteItem(new String("b"));
        System.out.println("Deleted 'b': " + list);
        list.replaceItem(new String("d"), new String("x"));
        System.out.println("Replaced 'd': " + list);
        list.insertBefore(new String("e"), new String("y"));
        System.out.println("Inserted 'y': " + list);
        list.deleteItem(new String("a"));
        System.out.println("Deleted 'a': " + list);
        list.insertBefore(new String("c"), new String("w"));
        System.out.println("Inserted 'w': " + list);
        list.deleteItem(new String("y"));
        System.out.println("Deleted 'y': " + list);
        list.insertAfter(new String("f"), new String("d"));
        System.out.println("Inserted 'd': " + list);
        list.clear();
        System.out.println("Cleared list: " + list);
    }
}//end of class
