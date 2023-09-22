public class DoublyLinkedList {
    Node head;

    private DoublyLinkedList(Node head) {
        this.head = head;
    }

    public Node head() {
        return this.head;
    }

    public static DoublyLinkedList createLinkedList(int size) {
        Node node = new Node();
        Node head = node;
        for (int j = 0; j < size - 1; j++) {
            node.next = new Node();
            node.next.prev = node;
            node = node.next;
        }
        return new DoublyLinkedList(head);
    }

    public void append(DoublyLinkedList b) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = b.head;
    }

    public void add(Node item){
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = item;
        node.next.prev = node;
    }

    public int length(){
        if(head == null){
            return 0;
        }

        int counter = 1;
        Node node = this.head;

        while (node.next != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public boolean find(Node item){
        Node node = this.head;

        if(head == null){
            return false;
        }

        if(node == item){
            return true;
        }

        while (node.next != null) {
            if(node == item)
                return true;
            node = node.next;
        }
        return false;
    }

    public void remove(Node item){
        Node node = this.head;

        if(head == null){
            return;
        }

        if(node == item){
            node.next.prev = null;
            head = node.next;
        }

        while (node.next != null) {
            if(node.next == item){
                Node temp = node.next;
                node.next = node.next.next;
                node.next.prev = node;
                temp.next = null;
                temp.prev = null;    
                return;
            }
            node = node.next;
        }
    }

    public void unlink(Node node){
        if(node.prev == null && node.next == null){
            head = null;
        }

        else if(node.prev == null){
            head = node.next;
            head.prev = null;
        }

        else if(node.next == null){
            node.prev.next = null;
        }

        else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node = null;
        }
    }

    public void insert(Node node){
        if(head == null){
            return;
        }
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }
}