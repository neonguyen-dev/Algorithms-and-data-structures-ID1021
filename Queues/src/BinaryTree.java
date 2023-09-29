import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
    
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    
        public void add(Integer key, Integer value) {
            if (this.key == key) {
                this.value = value;
                return;
            }
    
            if (this.key > key) {
                if (left != null)
                    left.add(key, value);
                else
                    left = new Node(key, value);
            }
    
            else if (this.key < key) {
                if (right != null)
                    right.add(key, value);
                else
                    right = new Node(key, value);
            }
        }
    
        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }
    }

    Node root;

    public Iterator<Integer> iterator(){
        return new TreeIterator(root);
    }

    public BinaryTree(){
        root = null;
    }

    public void add(Integer key, Integer value){
        if(root == null)
            root = new Node(key, value);
        else
            root.add(key, value);
    }

    public Integer lookup(Integer key){
        Node current = root;
        
        while(current != null){
            if(current.key.intValue() == key.intValue()){
                return current.value;
            }
            
            if(current.key.intValue() > key.intValue()){
                current = current.left;
            }

            else if(current.key.intValue() < key.intValue()){
                current = current.right;
            }
        }
        return null;
    }
}