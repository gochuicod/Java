/**
    Name: Darelle Gochuico
    Subject: DASTRUC21
    EDPCode: 05173
    Schedule: Mondays and Wednesdays, 3:00 PM - 5:30 PM

    MySetTest
*/

public class MySetTest{
   static public void main(String... args){
      MySet setA = new MySetArray(new String[]{"A","B","C","D"});
      MySet setB = new MySetArray(new String[]{"C","D","E"});
      MySet setD = new MySetArray(new String[]{"1","2","3","4","5","6"});
      //
      System.out.println("Set A: "+setA);
      System.out.println("Set B: "+setB);
      //
      long startTime = System.nanoTime() ;
      MySet setC= setA.union(setB);
      long endTime = System.nanoTime();
      System.out.println("Time of execution(in microseconds): " + (endTime - startTime) / 10000);
      System.out.println("A U B: "+setC);
      setC= setA.intersect(setB);
      System.out.println("A ^ B: "+setC);
      setC= setA.subtract(setB);
      System.out.println("A - B: "+setC);
      setC= setB.subtract(setA);
      System.out.println("B - A: "+setC);
      setC= setA.crossproduct(setB);
      System.out.println("A x B: "+setC);
      System.out.println("Set D: "+setD);
      setD.deleteItem("6");
      System.out.println("Set D: "+setD);
      setD.clear();
      System.out.println("Set D: "+setD);
   }
}//end of class 
