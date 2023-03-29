/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    DASTRUC21, Finals Activity #1
*/

public class BubbleSort{
    //define the data container
    private Object[] items;
    private Object[] unsorted;
    private int count;//holds the actual number of elements in the structure
    public long sortTime;

    //define the constructors
    public BubbleSort(int size){ this.items = new Object[size]; this.unsorted = new Object[size]; }
    public BubbleSort(Object[] obj){
        this(obj.length);
        for(int i = 0; i < obj.length; items[count++] = obj[i], unsorted[i] = obj[i], i++);
    }
    public BubbleSort(){}

    //sentinel methods
    public boolean isEmpty(){ return count == 0; }
    public boolean isFull(){ return count == items.length; }

    //utility methods
    public boolean addItem(Object item){
        boolean ok = !isFull();
            if(ok) items[count++] = item;
        return ok;
    }

    //get the pivot point(middle cell) of the containers
    public int middleCell(){ return count / 2; }//integer division

    //sorting method
    public boolean sort(){
        //this is an ascending order sort
        boolean ok = !isEmpty();
            if(ok){
                //get the current time in millisecond
                long start = System.currentTimeMillis();
                //define the pass loop
                for(int i = 1; i < count; i++){
                    //define the bubble loop
                    for(int j = 0; j < count - i; j++){
                        //transform the data elements of the container into a Comparable object in order to use the compareTo()
                        //returns the alphanumerical order difference of two elements
                        Comparable c = (Comparable)items[j];
                        if(c.compareTo(items[j+1]) > 0){
                            //exchange the value of the cells
                            Object temp = items[j];
                            items[j] = items[j+1];
                            items[j+1] = temp;
                        }
                    }
                    //get the current time in millisecond
                    long end = System.currentTimeMillis();
                    sortTime = end - start;
                }
            }
        return ok;
    }


    //override the toString() methods
    public String originalSet(){//unsorted
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(int i = 0; i < count; i++){
                sb.append(unsorted[i]);
                    if(i < count - 1)
                        sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }

    public String ascending(){
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(int i = 0; i < count; i++){
                sb.append(items[i]);
                    if(i < count - 1)
                        sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }

    public String descending(){
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(int i = count - 1; i > -1; i--){
                sb.append(items[i]);
                    if(i > 0)
                        sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }
}//end of class
