package List.SinglyLinkedList;

public class SinglyLinkedList {
    private Node head;
    
    public void addFirst(int data){
        Node newnode = new Node(data);
        newnode.next = this.head;
        this.head = newnode;
    }
    
    public void addLast(int data){
        Node newnode = new Node(data);
        Node current = this.head;

        if(this.head == null) this.head = newnode;
        while(current != null){
            if(current.next == null){
                current.next = newnode;
                break;
            }
            current = current.next;
        }
    }
    
    public void deleteFirst(){
        try{
            this.head = this.head.next;
        } catch (NullPointerException e) {
            this.head = null;
        }
    }
    
    public void deleteLast(){
        Node current = this.head;
        Node previous = null;

        try{
            while(current != null){
                if(current.next == null){
                    previous.next = null;
                    current = null;
                    break;
                }
                previous = current;
                current = current.next;
            }
        } catch (NullPointerException e) {
            this.head = null;
        }
    }

    public void deleteItem(int data){
        Node current = this.head;
        Node previous = null;

        try {
            if(this.head.data == data){
                this.head = this.head.next;
            } else {
                while(current != null){
                    if(current.data == data){
                        previous.next = current.next;
                        current = null;
                        break;
                    }
                    
                    previous = current;
                    current = current.next;
                }
            }
        } catch (NullPointerException e) {
            this.head = null;
        }
    }
    
    public boolean exist(int data){
        Node current = this.head;
        
        while(current != null){
            if(current.data == data) return true;
            current = current.next;
        }
      
        return false;
    }
    
    public void display(){
        Node current = this.head;
        while(current != null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println();
    }
}