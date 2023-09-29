import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
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

    public Zip(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node linear(String code) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].code.equals(Integer.valueOf(code.replaceAll("\\s", "")))) {
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
            if (data[index].code.intValue() == Integer.valueOf(code.replaceAll("\\s", "")).intValue()) {
                return data[index];
            }
            if (data[index].code.intValue() < Integer.valueOf(code.replaceAll("\\s", "")).intValue() && index < last) {
                first = index + 1;
                continue;
            }
            if (data[index].code.intValue() > Integer.valueOf(code.replaceAll("\\s", "")).intValue() && index > first) {
                last = index - 1;
                continue;
            }
            return null;
        }
    }

    public Node lookup(String code) {
        return data[Integer.valueOf(code.replaceAll("\\s", "")).intValue()];
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

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[max];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

}
