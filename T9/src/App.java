import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String file = "kelly.txt";
        Trie trie = new Trie();
        List<String> words = Files.readAllLines(Paths.get(file));

        for (String string : words) {
            trie.add(string.toLowerCase().replaceAll("\\s", ""));
        }

        System.out.println();
    }

    private static String[] addWord(String[] array, String word){
        String[] temp = new String[array.length + 1];
        
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }
        temp[array.length] = word;

        return temp;
    }
}
