public class MyListLinked implements MyList{
    //data container
    private MyLink head, tail, temp;
    private int count;

    //constructors
    public MyListLinked(String[] newitems){ for(int i = 0; i < newitems.length; addItem(newitems[i]), i++); }
    public MyListLinked(){}
    
    //sentinels
    public boolean isFull(){ return false; }
    public boolean isEmpty(){ return count == 0; }
    
    //utility methods
    public boolean isItem(Object item){
        boolean found = false;
        //create traversing link
            for(MyLink tlink = head; tlink != null; tlink = tlink.getNext()){
                if(tlink.getItem().equals(item)){
                    temp = tlink; //save the reference of the searched item
                    found = true; //if found set it to true
                    break;
                }
            }
        return found;
    }
    public boolean addItem(Object item){
        boolean ok = !isItem(item);
        MyLink newlink = null;
            if(ok){
                newlink = new MyLink(item);
                if(!isEmpty()) tail.setNext(newlink);
                else head = newlink;
                    tail = newlink;
                    count++;
            }
        return ok;
    }
    public boolean deleteItem(Object item){
        boolean ok = isItem(item);
        //delete method
            if(ok){
                //case 1: if the item to delete is the head
                if(temp == head) head = temp.getNext();
                else{
                    MyLink temp2 = head;
                    for(; temp2.getNext() != temp; temp2 = temp2.getNext());
                    //case 2: if the item to delete is the tail
                        if(temp == tail){
                            tail = temp2;//re-orient the tail
                            tail.setNext(null);//set the tail next to null
                        }
                        //case 3: if the item to delete is between the head and tail
                        else temp2.setNext(temp.getNext());
                }
                temp = null; //kill the temp from memory
                count--;//decrement the count
            }
        return ok;
    }

    public boolean replaceItem(Object item, Object newitem){
        boolean ok = isItem(item);
            if(ok) temp.setItem(newitem);
        return ok;
    }
    public boolean insertBefore(Object item, Object newitem){
        boolean ok = isItem(item);
            MyLink previous = null, current = head, newlink = new MyLink(newitem);
            if(ok){
                for(MyLink tlink = head; tlink != temp; tlink = tlink.getNext()){
                    previous = current;
                    current = current.getNext();
                    if(current == null){
                        break;
                    }
                }
                if(previous == null){
                    newlink.setNext(current);
                    head = newlink;
                } else {
                    newlink.setNext(current);
                    previous.setNext(newlink);
                }
            }
        return ok;
    }
    public boolean insertAfter(Object item, Object newitem){
         boolean ok = isItem(item);
         if(ok){
            MyLink current = null, next = this.head, newlink = new MyLink(newitem);
            for(MyLink tlink = head; tlink != temp.getNext(); tlink = tlink.getNext()){
                current = next;
                next = next.getNext();
                if(current == null){
                    break;
                }
            }
            newlink.setNext(next);
            current.setNext(newlink);
         }
        return ok;

    }
    public void clear(){
       for(MyLink tlink = head; tlink != null; deleteItem(head.getItem()), tlink = tlink.getNext());
       count = 0;
    }

    //override the toString method
    public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(MyLink tlink = head; tlink != null; tlink = tlink.getNext()){
                sb.append(tlink.getItem());
                    if(tlink.getNext() != null)
                        sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }
}//end of class
