import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        int[] sizes = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600 };

        System.out.println("Linked list append, dynamic to static");

        for (int i = 0; i < sizes.length; i++) {
            benchDynamicToStatic(sizes[i]);
            System.out.println(sizes[i] + " elements: " + benchDynamicToStatic(sizes[i]) / 1000 + " microseconds");
        }

        System.out.println("\nLinked List append, static to dynamic");

        for (int i = 0; i < sizes.length; i++) {
            benchStaticToDynamic(sizes[i]);
            System.out.println(sizes[i] + " elements: " + benchStaticToDynamic(sizes[i]) / 1000 + " microseconds");
        }

        System.out.println("\nArray append");

        for (int i = 0; i < sizes.length; i++) {
            benchArrayAppend(sizes[i]);
            System.out.println(sizes[i] + " elements: " + benchArrayAppend(sizes[i]) / 1000 + " microseconds");
        }

        Random rand = new Random();
        int turns = 100;

        for (int i = 0; i < sizes.length; i++) {
            Node[] nodes = new Node[sizes[i]];
            LinkedList a = LinkedList.createLinkedList(sizes[i]);

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

    public static double benchDynamicToStatic(int n) {
        int turns = 100;
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < turns; i++) {
            LinkedList a = LinkedList.createLinkedList(n);
            LinkedList b = LinkedList.createLinkedList(100);

            long startTime = System.nanoTime();
            a.append(b);
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        return min;
    }

    public static double benchStaticToDynamic(int n) {
        int turns = 100;
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < turns; i++) {
            LinkedList a = LinkedList.createLinkedList(100);
            LinkedList b = LinkedList.createLinkedList(n);
            long startTime = System.nanoTime();
            a.append(b);
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        return min;
    }

    public static double benchArrayAppend(int n) {
        int turns = 100;
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < turns; i++) {
            int[] fixedArray = new int[100];
            int[] dynamicArray = new int[n];
            
            for (int j = 0; j < fixedArray.length; j++) {
                fixedArray[j] = j;
            }
            
            for (int j = 0; j < dynamicArray.length; j++) {
                dynamicArray[j] = j;
            }
            
            long startTime = System.nanoTime();
            int[] temp = new int[100 + n];
            for (int j = 0; j < fixedArray.length; j++) {
                temp[j] = fixedArray[j];
            }
            for (int j = fixedArray.length; j < temp.length; j++) {
                temp[j] = dynamicArray[j - fixedArray.length];
            }
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }

        return min;
    }
}
