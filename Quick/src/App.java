import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = randomize_array(100);
        sort(array, 0, array.length - 1);

        Random rand = new Random();

        LinkedList randomList = LinkedList.createLinkedList(100, rand);
        Node current = randomList.head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    
        System.out.println();
        randomList.sort(randomList.head, randomList.tail);
    
        current = randomList.head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
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
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
