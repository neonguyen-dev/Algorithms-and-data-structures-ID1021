import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private Stack<Node> stack;

    public TreeIterator(Node root) {
        stack = new Stack<Node>();
        
        Node current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }        
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        Node node = stack.pop();

        if(node.right != null){
            Node current = node.right;
            while(current != null){
                stack.push(current);
                current = current.left;
            }
        }

        return node.key;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
