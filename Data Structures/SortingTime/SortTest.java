/**
    Name: Darelle Gochuico
    Course and Year: BSIT - 2
    DASTRUC21, Finals Activity #1
*/

import java.util.*;

public class SortTest{
    public static void main(String[] args){
        BubbleSortProcess(); SelectionSortProcess(); InsertionSortProcess();
        CommandLineTable st = new CommandLineTable();
        st.setShowVerticalLines(true);
        st.setHeaders("", "500 items","1000","1500","2000","2500","3000","3500","4000","4500","5000");
        st.addRow("BubbleSort",BSData[0],BSData[1],BSData[2],BSData[3],BSData[4],BSData[5],BSData[6],BSData[7],BSData[8],BSData[9]);
        st.addRow("SelectionSort",SSData[0],SSData[1],SSData[2],SSData[3],SSData[4],SSData[5],SSData[6],SSData[7],SSData[8],SSData[9]);
        st.addRow("InsertionSort",ISData[0],ISData[1],ISData[2],ISData[3],ISData[4],ISData[5],ISData[6],ISData[7],ISData[8],ISData[9]);
        st.print();
    }

    //stores processed data
    public static String[] BSData = new String[10];
    public static String[] SSData = new String[10];
    public static String[] ISData = new String[10];

    //Bubble Sort Process
    public static void BubbleSortProcess(){
        int size = 500;
            for(; size < 5000; size += 500){
                Integer[] items = new Integer[size];
                java.util.Random r = new java.util.Random();
                for(int i = 0; i < size; items[i] = r.nextInt(size), i++);
                BubbleSort bs = new BubbleSort(items);
                bs.sort();
                String sortTime = Long.toString(bs.sortTime);
                for(int j = 0; j < BSData.length; BSData[j] = sortTime + " ms", j++);
            }
    }
    
    //Selection Sort Process
    public static void SelectionSortProcess(){
        int size = 500;
            for(; size < 5000; size += 500){
                Integer[] items = new Integer[size];
                java.util.Random r = new java.util.Random();
                for(int i = 0; i < size; items[i] = r.nextInt(size), i++);
                SelectionSort ss = new SelectionSort(items);
                ss.sort();
                String sortTime = Long.toString(ss.sortTime);
                for(int j = 0; j < SSData.length; SSData[j] = sortTime + " ms", j++);
            }
    }
    
    //Insertion Sort Process
    public static void InsertionSortProcess(){
        int size = 500;
            for(; size < 5000; size += 500){
                Integer[] items = new Integer[size];
                java.util.Random r = new java.util.Random();
                for(int i = 0; i < size; items[i] = r.nextInt(size), i++);
                InsertionSort is = new InsertionSort(items);
                is.sort();
                String sortTime = Long.toString(is.sortTime);
                for(int j = 0; j < ISData.length; ISData[j] = sortTime + " ms", j++);
            }
    }
}//end of class

class CommandLineTable{
    //attributes
    private static final String HORIZONTAL_SEP = "-";
    private String verticalSep;
    private String joinSep;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public CommandLineTable() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        verticalSep = showVerticalLines ? "|" : "";
        joinSep = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow(String... cells) {
        rows.add(cells);
    }

    //prints the entire table
    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    //prints appropriate lines to separate data
    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSep.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSep + line + (i == columnWidths.length - 1 ? joinSep : ""));
        }
        System.out.println();
    }

    //prints row data and lines
    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSep : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSep, s, verStrTemp);
            }
        }
        System.out.println();
    }
}
