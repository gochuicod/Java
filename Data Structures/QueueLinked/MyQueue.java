/**
   MyQueue interface
*/

public interface MyQueue{
   //define utility methods
   public void clear(); //remove all queue entries
   //sentinel methods
   public boolean isFull();
   public boolean isEmpty();
   //allowable operations
   public boolean enqueue(Object item);
   public Object peek(); //get the content at the HEAD/FRONT of the queue
   public Object dequeue();

}//end of interface
