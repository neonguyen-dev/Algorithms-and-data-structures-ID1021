import java.io.BufferedReader;
import java.io.FileReader;

public class ZipBucket {
    Node[][] data;
    int max;
    int[] keys;
    int mod;

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

    public ZipBucket(int mod, String file) {
        this.mod = mod;
        data = new Node[mod][];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node tempNode = new Node(code, row[1], Integer.valueOf(row[2]));

                int hashKey = code % mod;

                Node[] tempArray = new Node[data[hashKey].length + 1];
                for (int j = 0; j < data[hashKey].length - 1; j++) {
                    tempArray[j] = data[hashKey][j];
                }
                tempArray[tempArray.length - 1] = tempNode;
                data[hashKey] = tempArray;

                i++;
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookup(String code) {
        int zipCode = Integer.valueOf(code.replaceAll("\\s", ""));
        int hashKey = zipCode % mod;
        for (int i = 0; i < data[hashKey].length; i++) {
            if (zipCode == data[hashKey][i].code) {
                return data[hashKey][i];
            }
        }
        return null;
    }
}
