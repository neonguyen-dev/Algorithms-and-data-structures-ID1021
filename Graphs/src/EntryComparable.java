import java.util.Comparator;

public class EntryComparable implements Comparator<Entry> {
    @Override
    public int compare(Entry node1, Entry node2) {
        if (node1.distance < node2.distance)
            return -1;

        if (node1.distance > node2.distance)
            return 1;

        return 0;
    }
}
