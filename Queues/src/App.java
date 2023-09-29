public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.add(5, 105);
        tree.add(2, 102);
        tree.add(7, 107);
        tree.add(1, 101);
        tree.add(8, 108);
        tree.add(6, 106);
        tree.add(3, 103);
        for (int i : tree)
            System.out.println("next value " + i);

        ArrayQueue queue = new ArrayQueue(100);

        for (int i = 0; i < 101; i++) {
            queue.add(i);
        }
        for (int i = 0; i < 102; i++) {
            queue.remove();
        }
    }
}
