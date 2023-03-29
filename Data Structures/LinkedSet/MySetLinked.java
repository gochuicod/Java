/**
    MySetLinked - a linked-list implementation of the MySet interface
*/

public class MySetLinked implements MySet{
    //define the data container
    private MyLink head, tail, temp;
    private int count;

    //define constructor
    public MySetLinked(String[] newitems){
        for(int i = 0; i < newitems.length; addItem(newitems[i]), i++);
    }

    //default constructor
    public MySetLinked(){}
    
    //define sentinel methods
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
    public void clear(){
        //assignment for next meeting, to be checked
        // for(MyLink tlink = head; tlink.getNext() != null; tlink.setItem(""), tlink.setNext(null), tlink.getNext());
        // instructor's solution
        // MyLink temp2 = head;
        // for(; temp2.getNext() != null; temp2 = temp.getNext()){
        //     head = temp2.getNext();
        //     temp2 = null;
        // }
        //
        // A more simple answer. If it leads to null pointer exception, it means it's correct
        MyLink tlink = head;
        for(; tlink != null; deleteItem(head.getItem()), tlink = tlink.getNext());
        count = 0;
    }
    //allowable operations
    public MySet union(MySet paraset){
        MySet result = new MySetLinked();
            //using the current set, populate the result set
            MyLink tlink = head;
            for(; tlink != null; result.addItem(tlink.getItem()), tlink = tlink.getNext());
            //using the parameter set, populate the result set
            java.util.StringTokenizer st = new java.util.StringTokenizer(paraset.toString(), "{},");
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                result.addItem(token);
            }
        return result;
    }
    public MySet intersect(MySet paraset){
        MySet result = new MySetLinked();
        MyLink tlink = head;
            for(; tlink != null; tlink = tlink.getNext()){
                if(paraset.isItem(tlink.getItem()))
                    result.addItem(tlink.getItem());
            }
        return result;
    }
    public MySet subtract(MySet paraset){
        MySet result = new MySetLinked();
        MyLink tlink = head;
            for(; tlink != null; tlink = tlink.getNext()){
                if(!paraset.isItem(tlink.getItem()))
                    result.addItem(tlink.getItem());
            }
        return result;
    }
    public MySet crossproduct(MySet paraset){
        MySet result = new MySetLinked();
            MyLink tlink = head;
                for(; tlink != null; tlink = tlink.getNext()){
                    java.util.StringTokenizer st = new java.util.StringTokenizer(paraset.toString(), "{},");
                    while(st.hasMoreTokens()){
                        String token = st.nextToken();
                        MySet tempset = new MySetLinked();
                            tempset.addItem(tlink.getItem());
                            tempset.addItem(token);
                            if(tempset.cardinality() == 2)
                                result.addItem(tempset);
                    }
                }
        return result;
    }

    public int cardinality(){ return count; }//return the count 
    //
    public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append(("{"));
            for(MyLink tlink = head; tlink != null; tlink = tlink.getNext()){
                sb.append(tlink.getItem());
                    if(tlink.getNext() != null)
                        sb.append(",");
            }
            sb.append(("}"));
        return sb.toString();
    }
}//end of class
