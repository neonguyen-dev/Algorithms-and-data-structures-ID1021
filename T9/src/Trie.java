public class Trie {
    Node root;

    public Trie() {
        root = null;
    }

    public Integer letterToInt(char letter) {
        if ((int) letter >= 97 && (int) letter <= 113) {
            return (int) letter - 97;
        }
        else if((int) letter >= 114 && (int) letter <= 118){
            return (int) letter - 98;
        }
        else if((int) letter >= 120 && (int) letter <= 122){
            return (int) letter - 98;
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
        if (code >= 0 && code <= 25) {
            return (char) (code + 97);
        }
        switch (code) {
            case 26:
                return 'å';
            case 27:
                return 'ä';
            case 28:
                return 'ö';
        }
        return null;
    }

    public Integer keyToIndex(char key){
        if ((int) key >= 49 && (int) key <= 57) {
            return (int) key - 49;
        }
        return null;
    }

    public Character indexToKEy(int index){
        if (index >= 0 && index <= 8){
            return (char) (index + 49);
        }
        return null;
    }


}