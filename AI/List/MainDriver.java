public class MainDriver {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(50);
        ll.addFirst(22);
        ll.display();
        ll.addFirst(20);
        ll.display();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.deleteFirst();
        ll.display();
        // Node head = null;
        // Node n1 = new Node(22);
        // Node n2 = new Node(50);
        // Node newnode = new Node(20);
        // head = n1;
        // n1.next = n2;
        // n2.next = null;

        // newnode.next = head;
        // head = newnode;

        // // h -> n1 ->n2 -> null
        // Node temp = head;
        // while(temp != null){
        //     System.out.print(temp.data+"->");
        //     temp = temp.next;
        // }
        // Node temp2 = head;
        // System.out.println("displaying twice!");
        // while(temp2 != null){
        //     System.out.print(temp2.data+"->");
        //     temp2 = temp2.next;
        // }
    }
}