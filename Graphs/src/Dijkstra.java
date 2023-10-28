import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {
    private static final int mod = 541;

    public static void main(String[] args) {
        int turns = 1000;
        Dijkstra dijkstra = new Dijkstra();
        Map map = new Map("europe.csv");
        String from = "Göteborg";
        String to = "Umeå";
        Entry entry = dijkstra.shortest(map.lookup(from), map.lookup(to));
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < turns; i++) {
            long t0 = System.nanoTime();
            //LinkedList<Entry> entries = dijkstra.shortest(map.lookup(from));
            entry = dijkstra.shortest(map.lookup(from), map.lookup(to));
            long time = (System.nanoTime() - t0) / 1_000;
            if(time < min){
                min = time;
            }
        }

        System.out.println("shortest: " + entry.distance + " min (" + min + " ms)");

        for (int i = 0; i < entry.path.size(); i++) {
            System.out.println(entry.path.get(i).name);
        }
        /*for (int i = 0; i < entries.size(); i++) {
            System.out.println(i + " " + entries.get(i).city.name + ": " + entries.get(i).distance + " min");

            /*for (int j = 0; j < entries.get(i).path.size(); j++) {
                System.out.println(entries.get(i).path.get(j).name);
            }*/
        //}
        // System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }

    public LinkedList<Entry> shortest(City from) {
        PriorityQueue<Entry> queue = new PriorityQueue<>(new EntryComparable());
        City[] visited = new City[mod];
        LinkedList<City> path = new LinkedList<>();
        LinkedList<Entry> entries = new LinkedList<Entry>();
        
        queue.add(new Entry(from, 0, new LinkedList<City>()));
        visited[hash(from.name)] = from;

        while (!queue.isEmpty()) {
            Entry temp = queue.poll();
            entries.add(temp);
            
            for (int j = 0; j < temp.city.neighbors.length; j++) {
                Connection conn = temp.city.neighbors[j];
                int distance = conn.distance + temp.distance;
                path = (LinkedList<City>) temp.path.clone();
                
                if(!isVisited(visited, conn.city.name)){
                    path.add(conn.city);
                    queue.add(new Entry(conn.city,distance,path));
                }
                else{
                    for (Entry entry : queue) {
                        if(entry.city.equals(conn.city)){
                            if(entry.distance > distance){
                                path.add(conn.city);
                                queue.remove(entry);
                                queue.add(new Entry(conn.city, distance, path));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return entries;
    }

    public Entry shortest(City from, City to) {
        PriorityQueue<Entry> queue = new PriorityQueue<>(new EntryComparable());
        queue.add(new Entry(from, 0, new LinkedList<City>()));
        City[] visited = new City[mod];
        visited[hash(from.name)] = from;
        LinkedList<City> path = new LinkedList<>();

        while (!queue.isEmpty()) {
            Entry temp = queue.poll();
            
            if (temp.city.equals(to)) {
                /*int count = 0;
                for (int i = 0; i < visited.length; i++) {
                    if(visited[i] != null)
                        count++;
                }
                System.out.println(count);*/
                return temp;
            }
            
            for (int j = 0; j < temp.city.neighbors.length; j++) {
                Connection conn = temp.city.neighbors[j];
                int distance = conn.distance + temp.distance;
                path = (LinkedList<City>) temp.path.clone();
                
                if(!isVisited(visited, conn.city.name)){
                    path.add(conn.city);
                    queue.add(new Entry(conn.city,distance,path));
                }
                else{
                    for (Entry entry : queue) {
                        if(entry.city.equals(conn.city)){
                            if(entry.distance > distance){
                                queue.remove(entry);
                                path.add(conn.city);
                                queue.add(new Entry(conn.city, distance, path));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean isVisited(City[] visited, String name) {
        Integer i = hash(name);
        while (visited[i] != null) {
            if (visited[i].name.equals(name)) {
                return true;
            }
            i++;
            i %= mod;
        }
        visited[i] = new City(name);
        return false;
    }

    private static Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
}
