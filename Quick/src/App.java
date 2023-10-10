import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400};
        int turns = 1000;
        Random rand = new Random();

        for (int i = 0; i < sizes.length; i++) {
            int[] array = randomize_array(sizes[i]);

            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                sort(array, 0, array.length - 1);
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
                array = randomize_array(sizes[i]);
            }
            System.out.println(sizes[i] + " " + min/1000);
        }

        for (int i = 0; i < sizes.length; i++) {
            LinkedList randomList = LinkedList.createLinkedList(sizes[i], rand);

            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                randomList =LinkedList.quickSort(randomList.head, randomList.tail);
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
                randomList = LinkedList.createLinkedList(sizes[i], rand);
            }
            System.out.println(sizes[i] + " " + min/1000);
        }
    }

    static int[] randomize_array(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        return array;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);

            sort(arr, low, mid - 1);
            sort(arr, mid + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int mid = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                mid++;
                int temp = arr[mid];
                arr[mid] = arr[j];
                arr[j] = temp;
            }
        }
        mid++;
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
        return mid;
    }
}
