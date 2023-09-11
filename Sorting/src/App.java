import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = randomize_array(1000);
        //section_sort(array);
        insertion_sort(array);
        System.out.println("sorted");
    }

    public static int[] randomize_array(int size) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        return array;
    }

    public static void section_sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i + 1; j < array.length; j++) {
                // If the element at position j is smaller than the value
                // at the candidate position - then you have a new candidate
                if (array[j] < array[cand]) {
                    cand = j;
                }
            }
            // Swap the item at position i with the item at the candidate position.
            int temp = array[i];
            array[i] = array[cand];
            array[cand] = temp;
        }
    }

    public static void insertion_sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > key; j--) {
                // for each element from i towards 1, swap the item found with the
                // item before it if it is smaller
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
}
