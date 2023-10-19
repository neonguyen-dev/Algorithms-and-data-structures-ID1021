import java.io.BufferedReader;
import java.io.FileReader;

public class ZipInt {
    Node[] data;
    int max;
    int[] keys;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public ZipInt(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                //data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
                //i++;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node linear(int code) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].code.equals(code)) {
                return data[i];
            }
        }
        return null;
    }

    public Node binary(int code) {
        int first = 0;
        int last = max;

        while (true) {
            int index = (last + first) / 2;
            if (data[index].code.intValue() == code) {
                return data[index];
            }
            if (data[index].code.intValue() < code && index < last) {
                first = index + 1;
                continue;
            }
            if (data[index].code.intValue() > code && index > first) {
                last = index - 1;
                continue;
            }
            return null;
        }
    }

    public Node lookup(int code) {
        return data[code];
    }

    int hash(int code, int mod) {
        return code % mod;
    }

    public void generateKeys(int mod){
        int k = 0;
        keys = new int[max + 1];
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null){
                keys[k] = hash(data[i].code,mod);
                k++;
            }
        }
    }

    public int[] collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        /*System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();*/

        return cols;
    }
}