public class App {
    public static void main(String[] args) throws Exception {
        bench(1000);

        double t = bench(1000);
        System.out.println("Time for pushing and popping a 1000 elements: " + t + " ns");
    }

    public static double bench(int n) throws Exception {
        int turns = 100;

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < turns; i++) {
            double t = pushAndPop(n, true);
            if (t < min) {
                min = t;
            }
        }

        return min;
    }

    public static double pushAndPop(int n, boolean dynamic) throws Exception {
        Stack stack;

        if (dynamic)
            stack = new Dynamic(4);
        else
            stack = new Static(1024);

        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime);
    }

    public static double sampleProgram(int n) throws Exception {
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
            // Change boolean to switch between static/dynamic
            Calculator calc = new Calculator(expr, true);
            int res = calc.run();
            // System.out.println("Calculator: res = " + res);
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000;
    }
}