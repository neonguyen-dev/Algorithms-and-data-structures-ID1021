public class LinkedList {
    Node head;

    private LinkedList(Node head) {
        this.head = head;
    }

    public Node head() {
        return this.head;
    }

    public static LinkedList createLinkedList(int size) {
        if(size < 1){
            return new LinkedList(null);
        }
        Node node = new Node();
        Node head = node;
        for (int j = 0; j < size - 1; j++) {
            node.next = new Node();
            node = node.next;
        }
        return new LinkedList(head);
    }

    public void append(LinkedList b) {
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
            head = node.next;
            return;
        }

        while (node.next != null) {
            if(node.next == item){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }    

    public void push(Node item) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = item;
    }

    public Node pop() throws Exception {
        if (this.head == null) {
            throw new Exception("Stack underflow");
        }

        Node node = this.head;

        if (node.next == null) {
            Node temp = node;
            head = null;
            return temp;
        }

        while (node.next.next != null) {
            node = node.next;
        }
        Node temp = node.next;
        node.next = null;
        return temp;
    }

    public void unlink(Node node){
        if(head == node){
            head = node.next;
            node.next = null;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            if(current.next == node){
                Node unlinkedNode = current.next;
                current.next = current.next.next;
                unlinkedNode.next = null;
                return;
            }
            current = current.next; 
        }
    }

    public void insert(Node node){
        node.next = head;
        head = node;
    }
}