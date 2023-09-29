public class Queue {
    public class Node {
        Node next;
        Integer item;
        Integer priority;

        public Node(Integer item, Integer priority) {
            next = null;
            this.item = item;
            this.priority = priority;
        }
    }

    Node head;
    Node tail;

    public Queue() {
        head = tail = null;
    }

    public void add(Integer item, Integer priority) {
        if (head == null) {
            head = new Node(item, priority);
            tail = head;
            return;
        }

        tail.next = new Node(item, priority);
        tail = tail.next;
    }

    public void add2(Integer item, Integer priority) {
        if (head == null) {
            head = new Node(item, priority);
            tail = head;
            return;
        }

        Node current = head;
        Node temp = new Node(item, priority);

        if (head.priority > priority) {
            temp.next = head;
            head = temp;
            return;
        }

        while (current.next != null && current.next.priority < priority) {
            current = current.next;
        }

        temp.next = current.next;
        current.next = temp;

        while(current.next != null){
            current = current.next;
        }
        tail = current;
    }

    public Integer remove() {
        Node toRemove = head;
        Node current = head;
        while (current != null) {
            if (current.priority < toRemove.priority) {
                toRemove = current;
            }
            current = current.next;
        }

        current = head;
        if(current == toRemove){
            head = current.next;
            return toRemove.priority;
        }

        while (current.next != toRemove) {
            current = current.next;
        }
        current.next = current.next.next;

        return toRemove.priority;
    }

    public Integer remove2() {
        Node temp = head;
        head = head.next;
        return temp.item;
    }
}
