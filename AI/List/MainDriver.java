public class MainDriver {
    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
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
    }
}