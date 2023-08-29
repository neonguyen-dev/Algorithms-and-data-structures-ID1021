import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100, 200, 400, 800, 1600, 3200 };
        bench(1000);
        for (int size : sizes) {
            double t = bench(size);
            System.out.println(size + " " + t);
        }
    }

    public static double access(int n) {
        int loop = 1000;
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = i;
        int[] indx = new int[loop];
        Random rnd = new Random();
        for (int k = 0; k < loop; k++) {
            indx[k] = rnd.nextInt(n);
        }
        long t0 = System.nanoTime();
        int sum = 0;
        for (int k = 0; k < loop; k++) {
            sum += array[indx[k]];
        }
        long t1 = System.nanoTime();
        return (double) (t1 - t0) / loop;
    }

    public static double bench(int n) {
        int turns = 1000;
        double min = Double.POSITIVE_INFINITY;
        ;
        for (int i = 0; i < turns; i++) {
            double t = access(n);
            if (t < min) {
                min = t;
            }
        }
        return min;
    }
}
