public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        String characters = "abcdefghijklmnoprstuvxyzåäö";
        
        for (int i = 0; i < characters.length(); i++) {
            System.out.println(trie.letterToInt(characters.charAt(i)));
        }

        System.out.println(trie.letterToInt('p'));
    }
}
