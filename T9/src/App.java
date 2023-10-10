import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String file = "kelly.txt";
        Trie trie = new Trie();
        List<String> words = Files.readAllLines(Paths.get(file));
        String[] keys = new String[0];

        for (String string : words) {
            trie.add(string.toLowerCase().replaceAll("\\s", ""));
        }

        for (int i = 0; i < words.size(); i++) {
            keys = addWord(keys, trie.characterToKey(words.get(i).toLowerCase().replaceAll("\\s", "")));
        }

        String[] temp = trie.search("1146");
        
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    private static String[] addWord(String[] array, String word){
        String[] temp = new String[array.length + 1];
        
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        temp[array.length] = word;

        return temp;
    }
}
