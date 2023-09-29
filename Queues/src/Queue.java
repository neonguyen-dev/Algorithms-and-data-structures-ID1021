public class Queue {
    public class Node {
        Node next;
        BinaryTree.Node node;
        Integer item;
        
        public Node(BinaryTree.Node node) {
            next = null;
            this.node = node;
        }
    }
    
    Node head;
    Node tail;

    public Queue() {
        head = tail = null;
    }

    public void add(BinaryTree.Node node) {
        if (head == null) {
            head = new Node(node);
            tail = head;
            return;
        }

        tail.next = new Node(node);
        tail = tail.next;
    }

    public BinaryTree.Node remove() {
        if (head.next == null) {
            Node temp = head;
            head = null;
            return temp.node;
        }

        Node temp = head;
        head = head.next;
        return temp.node;
    }
}
