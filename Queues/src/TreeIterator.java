import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator implements Iterator<Integer> {
    Queue queue;


    public TreeIterator(BinaryTree.Node root) {
        queue = new Queue();
        queue.add(root);
    }

    @Override
    public boolean hasNext() {
        return (queue.head != null);
    }

    @Override
    public Integer next() { 
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        BinaryTree.Node current = queue.remove();
        if(current.left != null){
            queue.add(current.left);
        }
        if(current.right != null){
            queue.add(current.right);
        }

        return current.key;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}