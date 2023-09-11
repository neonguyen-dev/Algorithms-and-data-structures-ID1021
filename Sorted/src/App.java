import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600 };
        int turns = 100;

        for (int i = 0; i < sizes.length; i++) {
            int[] array1 = sorted(sizes[i]);
            int[] array2 = sorted(sizes[i]);
            int[] randArray1 = keys(sizes[i], sizes[i]);
            int[] randArray2 = keys(sizes[i], sizes[i]);

            double min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < randArray1.length; k++) {
                    search_unsorted(randArray1, randArray2[k]);
                }
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
            }
            System.out.println("Unsorted linear search " + sizes[i] + " elements: " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < array2.length; k++) {
                    search_sorted(array1, array2[k]);
                }
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
            }
            System.out.println("Sorted linear search " + sizes[i] + " elements: " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                for (int k = 0; k < array2.length; k++) {
                    binary_search(array1, array2[k]);
                }
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
            }
            System.out.println("Binary search " + sizes[i] + " elements: " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < sizes.length; j++) {
                for (int j2 = 0; j2 < turns; j2++) {
                    long startTime = System.nanoTime();
                    better_version(array1, array2);
                    long endTime = System.nanoTime();
                    if ((endTime - startTime) < min) {
                        min = (endTime - startTime);
                    }
                }
            }
            System.out.println("Better version " + sizes[i] + " elements: " + min / 1000 + " microseconds\n");
        }

    }

    private static int[] keys(int loop, int n) {
        Random rand = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) {
            indx[i] = rand.nextInt(n * 5);
        }
        return indx;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
            else if(array[index] > key){
                return false;
            }
        }
        return false;
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true) {
            int index = (last + first) / 2;
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index - 1;
                continue;
            }
            return false;
        }
    }

    public static void better_version(int[] array1, int[] array2) {
        int next1 = 0;
        int next2 = 0;

        while (next1 < array1.length && next2 < array2.length) {
            if (array2[next2] < array1[next1]) {
                next2++;
            } else if (array2[next2] >= array1[next1]) {
                next1++;
            }
        }

    }
}