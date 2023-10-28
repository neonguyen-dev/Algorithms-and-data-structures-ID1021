import java.util.LinkedList;

public class Entry {
    public City city;
    public int distance;
    public LinkedList<City> path;

    public Entry(City city, int distance, LinkedList<City> path) {
        this.city = city;
        this.distance = distance;
        this.path = path;
    }
}
