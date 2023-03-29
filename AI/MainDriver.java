import List.SinglyLinkedList.SinglyLinkedList;
import Graph.*;

public class MainDriver {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addFirst(2);
        sll.display();
        sll.addLast(77);
        sll.display();
        sll.addFirst(22);
        sll.display();
        sll.addLast(6);
        sll.display();
        sll.addLast(43);
        sll.display();
        sll.addLast(76);
        sll.display();
        sll.addLast(89);
        sll.display();
        
        sll.deleteFirst();
        sll.display();
        sll.deleteItem(76);
        sll.display();
        sll.deleteLast();
        sll.display();
        sll.deleteFirst();
        sll.display();

        sll.deleteItem(6);
        sll.display();
        sll.deleteItem(43);
        sll.display();
        sll.deleteItem(77);
        sll.display();

        GraphTraversal gt = new GraphTraversal();
        gt.addPlace("A");
        gt.addPlace("B");
        gt.addPlace("C");
        gt.addPlace("D");
        gt.addPlace("E");
        gt.addPlace("F");
        gt.addPlace("G");
        gt.addPlace("H");

        gt.connect("A", "B");
        gt.connect("A", "C");
        gt.connect("A", "D");
        gt.connect("B", "E");
        gt.connect("C", "F");
        gt.connect("D", "G");
        gt.connect("E", "H");
        gt.connect("F", "H");

        gt.breadthFirstSearch("A", "H");
    }
}