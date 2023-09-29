import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        HeapArray heapArray = new HeapArray(10);

        for (int i = 0; i < heapArray.heaps.length; i++) {
            heapArray.add(i);
        }
        heapArray.remove();
        System.out.println(heapArray.remove());
    }
}
