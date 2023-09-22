public class Node {
    public Integer key;
    public Integer value;
    public Node left,right;

    public Node(Integer key, Integer value){
        this.key = key;
        this.value = value;
        left = right = null;
    }
    
    public void add(Integer key, Integer value){
        if(this.key == key){
            this.value = value;
            return;
        }

        if(this.key > key){
            if(left != null)
                left.add(key, value);
            else
                left = new Node(key, value);
        }

        else if(this.key < key){
            if(right != null)
                right.add(key, value);
            else
                right = new Node(key, value);
        }
    }
}
