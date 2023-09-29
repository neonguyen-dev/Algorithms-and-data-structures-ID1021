public class Paths {
    City[] path;
    int sp;

    public Paths() {
        path = new City[54];
        sp = 0;
    }
    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        Paths paths = new Paths();
        String from = args[0];
        String to = args[1];
        //Integer max = Integer.valueOf(args[2]);
        long t0 = System.nanoTime();
        Integer dist = paths.shortest(map.lookup(from), map.lookup(to), null);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
    }
    
    private Integer shortest(City from, City to, Integer max) {
        if ((max != null) && max < 0)
            return null;
        if (from == to)
            return 0;
            
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connection conn = from.neighbors[i];

                if(max != null){
                    Integer temp = shortest(conn.city, to , max - conn.distance);
                    if(temp != null && (shrt == null || shrt > temp + conn.distance)){
                        shrt = temp + conn.distance;
                    }
                } 
                else{
                    Integer temp = shortest(conn.city, to, null);
                    if(temp != null && (shrt == null || shrt > temp + conn.distance)){
                        shrt = temp + conn.distance;
                        max = temp - conn.distance;
                    }
                }

            }
        }
        path[sp--] = null;
        return shrt;
    }

}
