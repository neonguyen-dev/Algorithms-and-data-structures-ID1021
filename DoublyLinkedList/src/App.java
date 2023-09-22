import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int sizes[] = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600 };
        Random rand = new Random();
        int turns = 100;

        for (int i = 0; i < sizes.length; i++) {
            Node[] nodes = new Node[sizes[i]];
            DoublyLinkedList a = DoublyLinkedList.createLinkedList(sizes[i]);

            Node node = a.head;
            for (int j = 0; j < sizes[i]; j++) {
                nodes[j] = node;
                node = node.next;
            }

            int[] randomIndices = new int[1000];
            for (int j = 0; j < randomIndices.length; j++) {
                randomIndices[j] = rand.nextInt(sizes[i] - 1);
            }

            double min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < randomIndices.length; k++) {
                    a.unlink(nodes[randomIndices[k]]);
                    a.insert(nodes[randomIndices[k]]);
                }
                long endTime = System.nanoTime();

                if(min > (endTime - startTime)){
                    min = (endTime - startTime);
                }
            }
            System.out.println(sizes[i] + " " + min/1000);
        }
    }
}
