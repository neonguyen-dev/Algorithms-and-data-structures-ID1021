import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        benchPriority();
        benchHeap();
        benchHeapArray();
    }

    public static void benchHeap() {
        Random rand = new Random();
        int turns = 100;
        
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            Heap heap = new Heap();
            long startTime = System.nanoTime();
            for (int j = 0; j < 1023; j++) {
                heap.add(rand.nextInt(10000));
            }
            for (int j = 10; j <= 100; j += 10) {
                heap.push(j);
            }
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println("\nHeap add and push operation: " + min/1000 + " microseconds");

        min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            Heap heap = new Heap();
            long startTime = System.nanoTime();
            for (int j = 0; j < 1023; j++) {
                heap.add(rand.nextInt(10000));
            }
            for (int j = 10; j <= 100; j += 10) {
                heap.pushRemoveAndAdd(j);
            }
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println("Heap add and push(remove and add) operation: " + min/1000 + " microseconds");
    }

    public static void benchHeapArray() {
        Random rand = new Random();
        int turns = 100;
        
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            HeapArray heap = new HeapArray(10000);
            long startTime = System.nanoTime();
            for (int j = 0; j < 1023; j++) {
                heap.add(rand.nextInt(10000));
            }
            for (int j = 10; j <= 100; j += 10) {
                heap.push(j);
            }
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println("\nHeap Array add and push operation: " + min/1000 + " microseconds");
    }

    public static void benchPriority() {
        int[] sizes = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600 };
        Queue queue = new Queue();
        Random rand = new Random();
        int turns = 100;

        for (int i = 0; i < sizes.length; i++) {
            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < sizes[i]; k++) {
                    queue.add(null, rand.nextInt(sizes[i]));
                }
                for (int k = 0; k < sizes[i]; k++) {
                    queue.remove();
                }
                long endTime = System.nanoTime();

                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
            }
            System.out.println("\nFast add and slow remove " + sizes[i] + ": " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < sizes[i]; k++) {
                    queue.add2(null, rand.nextInt(sizes[i]));
                }
                for (int k = 0; k < sizes[i]; k++) {
                    queue.remove2();
                }
                long endTime = System.nanoTime();

                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
            }
            System.out.println("Slow add and fast remove " + sizes[i] + ": " + min / 1000 + " microseconds");
        }

    }
}
