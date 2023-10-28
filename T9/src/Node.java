public class Node {
    public Node[] next;
    public boolean word;

    public Node() {
        next = new Node[27];
        word = false;
    }

    public void add(String key, int i) {
        if(i == key.length()){
            word = true;
            return;
        }

        int index = Trie.letterToInt(key.charAt(i++));
        if (this.next[index] == null) {
            this.next[index] = new Node();
        }
        
        this.next[index].add(key, i);
    }
}