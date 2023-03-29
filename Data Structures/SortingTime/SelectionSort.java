/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    DASTRUC21, Finals Activity #1
*/

public class SelectionSort{
    //data container
    private Object[] items, unsorted;
    //utility variables
    private int count, index, position;
    public long sortTime;

    //define the constructors
    public SelectionSort(Object[] obj){
        items = new Object[obj.length];
        unsorted = new Object[obj.length];
        //populate the container
        for(int i = 0; i < obj.length; items[count++] = obj[i], unsorted[i] = obj[i], i++);
    }
    public SelectionSort(int size){
        items = new Object[size];
        unsorted = new Object[size];
    }

    //sentinel methods
    public boolean isEmpty(){ return count == 0; }
    public boolean isFull(){ return count == items.length; }

    //utility method for adding new item
    public boolean addItem(Object item){
        boolean ok = !isFull();
            if(ok){
                items[count] = item;
                unsorted[count++] = item;
            }
        return ok;
    }

    public boolean isItem(Object item){
        boolean found = false;
            if(!isEmpty()){
                //using sequential search
                for(int i = 0; i < count; i++){
                    if(item.equals(items[i])){
                        position = i;
                        found = true;
                        break;
                    }
                }
            }
        return found;
    }

    public boolean deleteItem(Object item){
        boolean ok = isItem(item);
            if(ok) items[position] = items[--count];
        return ok;
    }

    public void sort(){
    long start = System.currentTimeMillis();
        for(int i = 0; i < count - 1; i++){
            index = i;
            for(int j = i + 1; j < count; j++){
                Comparable c = (Comparable)items[index];
                //ascending
                if(c.compareTo(items[j]) > 0){
                    index = j;
                }
            }
            if(i != index){
                //exchange the content
                Object temp = items[i];
                items[i] = items[index];
                items[index] = temp;
            }
        }
    long end = System.currentTimeMillis();
    sortTime = end - start;
    }

    //display the raw data
    public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append("Unsorted Data: [");
            for(int i = 0; i < count; i++){
                sb.append(unsorted[i]);
                    if(i < count - 1) sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }

    public String ascending(){
        StringBuffer sb = new StringBuffer();
            sb.append("Ascending Data: [");
            for(int i = 0; i < count; i++){
                sb.append(items[i]);
                    if(i < count - 1) sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }

    public String descending(){
        StringBuffer sb = new StringBuffer();
            sb.append("Ascending Data: [");
            for(int i = count - 1; i > -1; i--){
                sb.append(items[i]);
                    if(i > 0) sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }
}//end of class
