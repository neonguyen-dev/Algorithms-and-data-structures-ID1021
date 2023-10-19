import java.io.BufferedReader;
import java.io.FileReader;

public class ZipBucketImproved {
    Node[] data;
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

    public ZipBucketImproved(int mod, String file) {
        this.mod = mod;
        data = new Node[mod*2];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                Node tempNode = new Node(code, row[1], Integer.valueOf(row[2]));

                int hashKey = code % mod;

                for (int j = hashKey % data.length; j < data.length; j++) {
                    if(data[j] == null){
                        data[j] = tempNode;
                        i++;
                        break;
                    }
                }
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookup(int code) {
        int hashKey = code % mod;
        int steps = 0;
        for (int i = hashKey % data.length; i < data.length; i++) {
            steps++;
            if(data[i] == null || data[i].code == code){
                System.out.println(steps);
                return data[i];
            }
        }

        return null;
    }
}
