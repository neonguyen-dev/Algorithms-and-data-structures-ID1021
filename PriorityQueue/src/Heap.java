public class Heap {
    public class Node {
        public Integer priority;
        public Node left, right;
    
        public Node(Integer priority) {
            this.priority = priority;
            left = right = null;
        }
    }

    Node root;
    int size;

    public Heap(){
        root = null;
        size = 0;
    }

    public int add(Integer priority){
        if(root == null){
            root = new Node(priority);
            return 0;
        }
        else{
            int depth = addRecursive(root, priority, 0);
            size++;
            return depth;
        }
    }

    private int addRecursive(Node currentNode, Integer priority, Integer depth){
        if(priority < currentNode.priority){
            int temp = currentNode.priority;
            currentNode.priority = priority;
            priority = temp;
        }

        if(currentNode.left == null){
            currentNode.left = new Node(priority);
            return depth + 1;
        }
        else if(currentNode.right == null){
            currentNode.right = new Node(priority);
            return depth + 1;
        }
        else{
            if(countNodes(currentNode.left) <= countNodes(currentNode.right)){
                return addRecursive(currentNode.left, priority, depth + 1);
            }
            else{
                return addRecursive(currentNode.right, priority, depth + 1);
            }
        }

    }
    private int countNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public Integer remove(){
        if(root == null){
            return null;
        }

        Node temp = root;
        
        if(size == 1){
            root = null;
        }
        else{
            removeRecursive(temp);
        }
        return temp.priority;
    }
    
    private void removeRecursive(Node currentNode){
        if(currentNode.left == null){
            currentNode.priority = currentNode.right.priority;
            if(currentNode.right.left == null && currentNode.right.right == null){
                currentNode.right = null;
                return;
            }
            removeRecursive(currentNode.right);
        }
        else if(currentNode.right == null){
            currentNode.priority = currentNode.left.priority;
            if(currentNode.right.left == null && currentNode.right.right == null){
                currentNode.left = null;
                return;
            }
            removeRecursive(currentNode.left);
        }
        else if(currentNode.right.priority < currentNode.left.priority){
            currentNode.priority = currentNode.right.priority;
            if(currentNode.right.left == null && currentNode.right.right == null){
                currentNode.right = null;
                return;
            }
            removeRecursive(currentNode.right);
        }
        else{
            currentNode.priority = currentNode.left.priority;
            if(currentNode.right.left == null && currentNode.right.right == null){
                currentNode.left = null;
                return;
            }
            removeRecursive(currentNode.left);
        }
    }
    public void push(Integer incr){
        int temp = root.priority += incr;
        this.remove();
        System.out.println(this.add(temp));
    }
}
