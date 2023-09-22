public class BinaryTree {
    Node root;

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
            if(current.key == key){
                return current.value;
            }
            
            if(current.key > key){
                current = current.left;
            }

            else if(current.key < key){
                current = current.right;
            }
        }
        return null;
    }
}