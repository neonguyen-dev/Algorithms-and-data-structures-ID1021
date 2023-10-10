public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void add(String key) {
        Node current = root;

        for (int i = 0; i < key.length(); i++) {
            int index = letterToInt(key.charAt(i));
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.word = true;
    }

    public String[] search(String keySequence) {
        String[] words = search(root, keySequence, "", new String[0]);
        return words;
    }

    private String[] search(Node current, String key, String path, String[] words){
        if(current == null){
            return words;
        }
        
        if(current.word){
            String temp[] = new String[words.length + 1];
            for (int i = 0; i < words.length; i++) {
                temp[i] = words[i];
            }
            temp[words.length] = path;
            words = temp;
        }
        
        if(path.length() == key.length()){
            return words;
        }
        

        int index = keyToIndex(key.charAt(path.length()));
        words = search(current.next[index * 3], key, path + intToLetter(index * 3), words);
        words = search(current.next[index * 3 + 1], key, path + intToLetter(index * 3 + 1), words);
        words = search(current.next[index * 3 + 2], key, path + intToLetter(index * 3 + 2), words);
        
        return words;
    }

    public Integer letterToInt(char letter) {
        if ((int) letter >= 97 && (int) letter <= 113) {
            return (int) letter - 97;
        } else if ((int) letter >= 114 && (int) letter <= 118) {
            return (int) letter - 98;
        } else if ((int) letter >= 120 && (int) letter <= 122) {
            return (int) letter - 99;
        }
        switch (letter) {
            case 'å':
                return 24;

            case 'ä':
                return 25;

            case 'ö':
                return 26;
        }
        return null;
    }

    public Character intToLetter(int code) {
        if (code >= 0 && code <= 15) {
            return (char) (code + 97);
        } else if (code >= 16 && code <= 20) {
            return (char) (code + 98);
        } else if (code >= 21 && code <= 23) {
            return (char) (code + 99);
        }

        switch (code) {
            case 24:
                return 'å';
            case 25:
                return 'ä';
            case 26:
                return 'ö';
        }
        return null;
    }

    public Integer keyToIndex(char key) {
        if ((int) key >= 49 && (int) key <= 57) {
            return (int) key - 49;
        }
        return null;
    }

    public Character indexToKey(int index) {
        if (index >= 0 && index <= 8) {
            return (char) (index + 49);
        }
        return null;
    }

    public String characterToKey(String character){
        String temp = "";
        for (int i = 0; i < character.length(); i++) {
            temp += (this.letterToInt(character.charAt(i)) / 3) + 1;
        }
        return temp;
    }
}