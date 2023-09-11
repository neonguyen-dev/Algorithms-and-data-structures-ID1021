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

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i < hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indices from lo to hi
        for ( int k = lo; k <= hi; k++) {
        // if i is greater than mid then
        // move the j'th item to the org array, update j
        // else if j is greate than hi then
        // move the i'th item to the org array, update i
        // else if the i'th item is smaller than the j¨ath item,
        // move the i'th item to the org array, update i
        // else
        // move the j'th item to the org array, update j
        }
        }        
}
