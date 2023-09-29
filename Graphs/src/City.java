public class City {
    String name;
    Connection[] neighbors;

    public City(String name) {
        this.name = name;
        neighbors = null;
    }

    public void add(City city, int distance) {
        if (neighbors == null) {
            neighbors = new Connection[1];
            neighbors[0] = new Connection(city, distance);
            return;
        }
        Connection[] temp = new Connection[neighbors.length + 1];
        for (int i = 0; i < neighbors.length; i++) {
            temp[i] = neighbors[i];
        }
        temp[temp.length - 1] = new Connection(city, distance);
        neighbors = temp;
    }
}