public class App {
    public static void main(String[] args) throws Exception {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
            Item.Value(10),
            Item.Value(2),
            Item.Value(5),
            Item.Mul(),
            Item.Add()
        };
        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println(" Calculator: res = " + res);
    }
}
