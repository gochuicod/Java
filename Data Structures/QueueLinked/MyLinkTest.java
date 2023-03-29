public class MyLinkTest{
    public static void main(String[] args){
        long startTime = System.nanoTime();//execution time demo
        MyQueue q = new MyQueueLinked();
            q.enqueue(new String("A"));
            q.enqueue(new String("B"));
            q.enqueue(new String("C"));
            q.enqueue(new String("D"));
            System.out.println("Peeking: " + q.peek());
            q.dequeue();
            System.out.println("Peeking: " + q.peek());
            System.out.println(q);
            q.dequeue();
            System.out.println("Peeking: " + q.peek());
            System.out.println(q);
            q.enqueue(new String("E"));
            System.out.println(q);
            q.clear();
            System.out.println(q);
            q.enqueue(new String("A"));
            q.enqueue(new String("B"));
            System.out.println(q);
            long elapsedTime = System.nanoTime() - startTime;//execution time demo
            System.out.println("Elapsed Time: " + elapsedTime / 1000000);//execution time demo

    }
}
