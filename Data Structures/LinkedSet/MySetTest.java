public class MySetTest{
    public static void main(String[] args){
        MySet setA = new MySetLinked(new String[]{"A","B","C","D"});
        MySet setB = new MySetLinked(new String[]{"C","D","E"});
        //
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        //
        MySet setC = setA.union(setB);
        System.out.println("A U B: " + setC);
        setC = setA.intersect(setB);
        System.out.println("A ^ B: " + setC);
        setC = setA.subtract(setB);
        System.out.println("A - B: " + setC);
        setC = setB.subtract(setA);
        System.out.println("B - A: " + setC);
        setC = setA.crossproduct(setB);
        System.out.println("A * B: " + setC);
        setA.clear();
        // System.out.println("SetA: " + setA);
        // setB.clear();
        // System.out.println("SetB: " + setB);
        // setA = new MySetLinked(new String[]{"A","B","C","D"});
        // setB = new MySetLinked(new String[]{"C","D","E"});
        // setC = setA.union(setB);
        // System.out.println("A U B: " + setC);
        // setC.deleteItem("C");
        // System.out.println(setC);
    }
}
