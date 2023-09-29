import java.util.Iterator;

public class BinaryTree implements Iterable<Integer>{
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