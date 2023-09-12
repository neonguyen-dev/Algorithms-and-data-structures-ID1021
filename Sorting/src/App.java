import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = {100,200,400,800,1600,3200,6400};
        int turns = 100;
        for (int i = 0; i < sizes.length; i++) {
            int[] array = randomize_array(sizes[i]);
            int[] tempArray = array.clone();

            double min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                section_sort(tempArray);
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
                tempArray = array.clone();
            }

            System.out.println("Section sort " + sizes[i] + " elements: " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                insertion_sort(tempArray);
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
                tempArray = array.clone();
            }

            System.out.println("Insertion sort " + sizes[i] + " elements: " + min / 1000 + " microseconds");

            min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < turns; j++) {
                long startTime = System.nanoTime();
                merge_sort(tempArray);
                long endTime = System.nanoTime();
                if ((endTime - startTime) < min) {
                    min = (endTime - startTime);
                }
                tempArray = array.clone();
            }

            System.out.println("Merge sort " + sizes[i] + " elements: " + min / 1000 + " microseconds\n");
        }
        //section_sort(array);
        //insertion_sort(array);
        //merge_sort(array);
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
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part
        // for all indices from lo to hi
        for (int k = lo; k <= hi; k++) {
            // if i is greater than mid then
            if (i > mid) {
                // move the j'th item to the org array, update j
                org[k] = aux[j];
                j++;
            }
            // else if j is greate than hi then
            else if (j > hi) {
                // move the i'th item to the org array, update i
                org[k] = aux[i];
                i++;
            }
            // else if the i'th item is smaller than the j¨ath item,
            else if (aux[i] < aux[j]) {
                // move the i'th item to the org array, update i
                org[k] = aux[i];
                i++;
            }
            // else
            else {
                // move the j'th item to the org array, update j
                org[k] = aux[j];
                j++;
            }
        }
    }

    private static void merge_sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;
            // sort the items from lo to mid
            merge_sort(org, aux, lo, mid);
            // sort the items from mid+1 to hi
            merge_sort(org, aux, mid + 1, hi);
            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }

    public static void merge_sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        merge_sort(org, aux, 0, org.length - 1);
    }
}
