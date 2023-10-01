public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        String characters = "abcdefghijklmnoprstuvxyzåäö";
        String word = "toffel";
        String key = "752224";
        
        trie.add(word);
        String[] words = trie.search(key, "", trie.root);
        System.out.println(words[0]);

        for (int i = 0; i < characters.length(); i++) {
            //System.out.println(trie.letterToInt(characters.charAt(i)));
            System.out.println(trie.intToLetter(i));
        }
    }
}
