import java.util.PriorityQueue;

public class Dijkstra {
    private City[] visited;
    private final int mod = 541;
    PriorityQueue<Entry> queue = new PriorityQueue<Entry>();
    
    public class Entry{
        City city;
        int distance;
        City[] path;
        public Entry(City city, int distance, City[] path){
            this.city = city;
            this.distance = distance;
            this.path = path;
        }
    }

    public void dijkstra(Map graph, City from, City to){
        visited = new City[mod];
        
        queue.add(new Entry(from, 0, new City[0])); 

        while(!queue.isEmpty()){
            Entry current = queue.remove();
            if(visited[hash(current.city.name)] != null){
                continue;
            }

            visited[hash(current.city.name)] = current.city;

            for (Connection connection : current.city.neighbors) {
                if((current.distance + connection.distance)){

                }
            }
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % 541) + name.charAt(i);
        }
        return hash % 541;
    }
}
