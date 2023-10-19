import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    int[] keys;

    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i] = new Node(row[0], row[1], Integer.valueOf(row[2]));
                i++;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node linear(String code) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].code.equals(code)) {
                return data[i];
            }
        }
        return null;
    }

    public Node binary(String code) {
        int first = 0;
        int last = max;
        
        while (true) {
            int index = (last + first) / 2;
            if (data[index].code.equals(code)) {
                return data[index];
            }
            if (data[index].code.compareTo(code) < 0 && index < last) {
                first = index + 1;
                continue;
            }
            if (data[index].code.compareTo(code) > 0 && index > first) {
                last = index - 1;
                continue;
            }
            return null;
        }
    }

    public Node lookup(String code) {
        return data[Integer.valueOf(code.replaceAll("\\s", "")).intValue()];
    }
}
