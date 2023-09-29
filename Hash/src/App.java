public class App {
    public static void main(String[] args) throws Exception {
        Zip zip = new Zip("postnummer.csv");
        zip.generateKeys(12345);
        zip.collisions(12345);

        ZipBucket zipBucket = new ZipBucket(12345, "postnummer.csv");
        System.out.println(zipBucket.lookup("261 35").name);
    }
}
