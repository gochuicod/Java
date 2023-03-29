/**
    Name: Darelle Gochuico
    Subject: DASTRUC21
    EDPCode: 05173
    Schedule: Mondays and Wednesdays, 3:00 PM - 5:30 PM

    MySetArray Assignment
*/

public class MySetArray implements MySet{
    private Object[] set = new Object[50];
    private int count;

    //constructors
    public MySetArray(Object[] set){
        for(int i = 0; i < set.length; addItem(set[i]), i++);
    }
    //default constructor
    public MySetArray(){}
    
    //define sentinel methods
    public boolean isFull(){ return count == set.length; }
    public boolean isEmpty(){ return count == 0; }
    //utility methods
    public boolean isItem(Object item){
        boolean found = false;
            for(int i = 0; i < cardinality(); i++){
                if(set[i] == item){
                    found = true;
                    break;
                }
            }
        return found;
    }
    public boolean addItem(Object item){
        boolean ok = !isFull();
            if(ok) set[count++] = item;
        return ok;
    }
    public boolean deleteItem(Object item){
        boolean ok = !isEmpty();
        int temp = 0;
            if(ok){
                for(int i = 0; i < cardinality(); i++){
                    if(set[i] != item) temp++;
                    else break;
                }
                for(int j = temp; j < cardinality(); set[j] = set[j+1], count--, j++);
            }
        return ok;
    }
    public void clear(){
        for(int i = 0; !isEmpty(); set[i] = set[i+1], count--, i++);
        // Other Option:
        // set = null; count = 0;
        // throw new NullPointerException("Array is null and void!");
    }
    //allowable operations
    public MySet union(MySet paraset){
        MySet result = new MySetArray();
            for(int i = 0; i < cardinality(); i++){
                if(isItem(set[i]) != paraset.isItem(set[i]))
                    result.addItem(set[i]);
            }
            java.util.StringTokenizer st = new java.util.StringTokenizer(paraset.toString(), "{},");
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                result.addItem(token);
            }
        return result;
    }
    public MySet intersect(MySet paraset){
        MySet result = new MySetArray();
            for(int i = 0; i < cardinality(); i++){
                if(paraset.isItem(set[i]) == isItem(set[i]))
                    result.addItem(set[i]);
            }
        return result;
    }
    public MySet subtract(MySet paraset){
        MySet result = new MySetArray();
            for(int i = 0; i < cardinality(); i++){
                if(isItem(set[i]) != paraset.isItem(set[i]))
                    result.addItem(set[i]);
            }
        return result;
    }
    public MySet crossproduct(MySet paraset){
        MySet result = new MySetArray();
            for(int i = 0, j = 0; i < cardinality(); i++){
                java.util.StringTokenizer st = new java.util.StringTokenizer(paraset.toString(), "{},");
                while(st.hasMoreTokens()){
                    String token = st.nextToken();
                    MySet tempset = new MySetArray();
                    if(!(set[i].equals(token))){
                        tempset.addItem(set[i]);
                        tempset.addItem(token);
                        if(tempset.cardinality() == 2){
                            result.addItem(tempset);
                        }
                    }
                }
            }
        return result;
    }
    public int cardinality(){ return count; }//return the count of the elements in a Set

    public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append("{");
            for(int i = 0; i < cardinality(); i++){
                sb.append(set[i]);
                    if(isItem(set[i]))
                        sb.append(",");
            }
            sb.append("}");
            sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }
}//end of class
