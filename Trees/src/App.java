public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600 };

        for (int i = 0; i < sizes.length; i++) {
            BinaryTree tree = new BinaryTree();
            recursion(tree, 1, sizes[i]);

            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < sizes.length; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < sizes[i]; k++) {
                    tree.lookup(k);
                }
                long endTime = System.nanoTime();
                if (min > (endTime - startTime)) {
                    min = (endTime - startTime);
                }
            }
            System.out.println(sizes[i] + " " + min / 1000);
        }
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
    }

    public static void recursion(BinaryTree tree, int a, int b) {
        if (b < a) {
            return;
        }
        tree.add((a + b) / 2, 1);
        recursion(tree, a, (a + b) / 2 - 1);
        recursion(tree, (a + b) / 2 + 1, b);
    }
}
