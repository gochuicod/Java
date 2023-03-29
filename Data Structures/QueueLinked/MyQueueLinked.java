/**
    Name: Darelle Gochuico
    MyQueueLinked Class
    DASTRUC 21, 3:00 - 5:00
*/

 public class MyQueueLinked implements MyQueue{
    private int count;
    private MyLink head, tail;

    //constructor
    public MyQueueLinked(){}

    //define utility methods
    public void clear(){ for(; !isEmpty(); dequeue()); }

    //sentinel methods
    public boolean isFull(){ return false; }
    public boolean isEmpty(){ return count == 0; }

    //allowable operations
    public boolean enqueue(Object item){
        boolean ok = isEmpty();
        MyLink link = new MyLink(item);
            if(ok){
                head = link;
            } else {
                tail.setNext(link);
            }
        tail = link;
        count++;
        return ok;
    }

    public Object peek(){ return (!isEmpty()) ? head.getItem() : null; }
    public Object dequeue(){
        Object item = peek();
            if(item != null){
                MyLink link = head;
                head = link.getNext();
                link = null;
                count--;
            }
        return item;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
            for(MyLink link = head; link != null; link = link.getNext()){
                sb.append(link.getItem());
            }
        return sb.toString();
    }
}//end of class
