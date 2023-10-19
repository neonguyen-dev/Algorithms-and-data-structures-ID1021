import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        int mod = bestHashOperator();
        benchBucketImproved(mod);
        // benchBucket(mod);
        // ench();
        // benchInt();
    }

    public static void bench() {
        int turns = 1000;
        Zip zip = new Zip("postnummer.csv");

        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            long startTime = System.nanoTime();
            // zip.lookup("111 15");
            // zip.binary("111 15");
            zip.linear("111 15");
            // zip.lookup("984 99");
            // zip.binary("984 99");
            // zip.linear("984 99");
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println(min);
    }

    public static void benchInt() {
        int turns = 1000;
        ZipInt zip = new ZipInt("postnummer.csv");

        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            long startTime = System.nanoTime();
            // zip.lookup(11115);
            // zip.binary(11115);
            // zip.linear(11115);
            // zip.lookup(98499);
            // zip.binary(98499);
            zip.linear(98499);
            long endTime = System.nanoTime();

            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println(min);
    }

    public static void benchBucket(int mod) {
        int turns = 1000;
        ZipBucket zipBucket = new ZipBucket(mod, "postnummer.csv");

        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            long startTime = System.nanoTime();
            // zipBucket.lookup(11115);
            // zipBucket.lookup(98499);
            long endTime = System.nanoTime();
            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println(min);
    }

    public static void benchBucketImproved(int mod) {
        int turns = 1000;
        ZipBucketImproved zipBucket = new ZipBucketImproved(mod, "postnummer.csv");

        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            long startTime = System.nanoTime();
            zipBucket.lookup(11115);
            //zipBucket.lookup(98499);
            long endTime = System.nanoTime();
            if ((endTime - startTime) < min) {
                min = (endTime - startTime);
            }
        }
        System.out.println(min);
    }

    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(n -> (number % n == 0));
    }

    public static int bestHashOperator() {
        ZipInt zipInt = new ZipInt("postnummer.csv");

        int minCollision = Integer.MAX_VALUE;
        int mod = 10000;
        for (int i = 10000; i <= 20000; i++) {
            if (isPrime(i)) {
                zipInt.generateKeys(i);
                int[] collisions = zipInt.collisions(i);
                int temp = 0;
                for (int j = 1; j < collisions.length; j++) {
                    if (collisions[j] == 0) {
                        break;
                    }
                    temp++;
                }
                if (temp < minCollision) {
                    minCollision = temp;
                    mod = i;
                    /*System.out.println(temp);

                    System.out.print(mod);
                    for (int j = 0; j < 10; j++) {
                        System.out.print("\t" + collisions[j]);
                    }
                    System.out.println();*/
                }
            }
        }
        return mod;
    }
}