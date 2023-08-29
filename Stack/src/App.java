public class App {
    public static void main(String[] args) throws Exception {
        int[] sizes = { 100, 200, 400, 800, 1600, 3200 };

        bench(1000);

        for (int i = 0; i < sizes.length; i++) {
            double t = bench(sizes[i]);
            System.out.println(sizes[i] + ": " + t + " µs");
        }
    }

    public static double bench(int n) {
        int turns = 1000;

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < turns; i++) {
            double t = sampleProgram(n);
            if (t < min) {
                min = t;
            }
        }

        return min;
    }

    public static double sampleProgram(int n) {
        Item[] expr = {
                // Item.Value(10),
                // Item.Value(2),
                // Item.Value(5),
                // Item.Mul(),
                // Item.Add()
                Item.Value(1),
                Item.Value(2),
                Item.Value(3),
                Item.Value(4),
                Item.Value(5),
                Item.Value(6),
                Item.Value(7),
                Item.Value(8),
                Item.Value(9),
                Item.Value(10),
                Item.Value(11),
                Item.Value(12),
                Item.Value(13),
                Item.Value(14),
                Item.Value(15),
                Item.Value(16),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add(),
                Item.Mul(),
                Item.Add()
        };
        
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            //Change boolean to switch between static/dynamic
            Calculator calc = new Calculator(expr, false);
            int res = calc.run();
            // System.out.println("Calculator: res = " + res);
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000;
    }
}