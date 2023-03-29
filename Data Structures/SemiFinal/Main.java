/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    DASTRUC21, Semi Final Programming Exam
*/

public class Main{
    public static void main(String[] args){
        char session;
        do{
            int list[] = new int[5];
            for(int i = 0; i < list.length;){
                System.out.print("Enter value #" + (i+1) + ": ");
                list[i] = new java.util.Scanner(System.in).nextInt();
                if(list[i] < 21) i++;
                else System.out.print("Value must not be greater than 20!\n");
            }
            long start = System.currentTimeMillis();
            Operations a = new Operations(list); 
            System.out.println("\n~~Output~~");
            System.out.println("List of items: " + a);
            System.out.println("Smallest: " + a.displaySmallest());
            System.out.println("Largest: " + a.displayLargest());
            System.out.println("Median: " + a.displayMedian());
            System.out.println("Sum: " + a.displaySum());
            System.out.println("Average: " + a.displayAverage());
            long end = System.currentTimeMillis();
            System.out.println("Total execution time: " + (end - start) + " ms");
            System.out.print("\nRun again?(y/n): ");
            session = new java.util.Scanner(System.in).next().toLowerCase().charAt(0);
        }while(session == 'y');
    }
}

class Operations{
    //attributes
    private int[] list;
    private int smallest, largest, median, sum, count;
    private float average;
    
    //constructors
    public Operations(int size){ this.list = new int[size]; }
    public Operations(int[] list){
        this(list.length);
        for(int i = 0; i < list.length; i++){ if(list[i] < 21) this.list[count++] = list[i]; }
    }
    public Operations(){}
    
    //allowable operations
    public int displaySmallest(){
        smallest = list[0];
        for(int i = 0; i < count; i++){
            if(list[i] < smallest) smallest = list[i];
        }
        return smallest;
    }
    public int displayLargest(){
        largest = list[0];
        for(int i = 0; i < count; i++){
            if(list[i] > largest) largest = list[i];
        }
        return largest;
    }
    public int displayMedian(){
        return median = list[count / 2];
    }
    public int displaySum(){
        for(int i = 0; i < count; sum += list[i], i++);
        return sum;
    }
    public float displayAverage(){
        return average = (float)sum / count;
    }

    //override toString()
    public String toString(){
        StringBuffer sb = new StringBuffer();
            sb.append("[");
            for(int i = 0; i < count; i++){
                sb.append(list[i]);
                    if(i < count - 1)
                        sb.append(",");
            }
            sb.append("]");
        return sb.toString();
    }
}
