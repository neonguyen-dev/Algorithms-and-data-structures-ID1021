import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] given = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        Random rnd = new Random();
        int sum = 0;

        long t0 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sum += given[rnd.nextInt(10)];
        }
        long t1 = System.nanoTime();
        System.out.println(" one read operation in " + (t1 - t0) / 1000 + " nanoseconds");
    }
}
