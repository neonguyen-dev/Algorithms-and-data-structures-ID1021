public class App {
    public static void main(String[] args) throws Exception {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
            //Item.Value(10),
            //Item.Value(2),
            //Item.Value(5),
            //Item.Mul(),
            //Item.Add()
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

        //Static
        Calculator calc = new Calculator(expr, true);
        
        long startTime = System.nanoTime();
        int res = calc.run();
        long endTime = System.nanoTime();
        
        System.out.println("Calculator: res = " + res);
        System.out.println("Benchmark time for static stack: " + (endTime - startTime) + " ns\n");
     }
}
