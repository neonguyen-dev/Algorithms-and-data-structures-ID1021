public class Node {
    public Node[] next;
    public boolean word;

    public Node() {
        next = new Node[27];
        word = false;
    }
}