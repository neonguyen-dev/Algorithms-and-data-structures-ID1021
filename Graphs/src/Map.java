import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    City[] cities;
    int mod = 541;

    public Map(String file) {
        cities = new City[mod];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                City firsCity = lookup(row[0]);
                City secondCity = lookup(row[1]);
                int distance = Integer.valueOf(row[2]);

                firsCity.add(secondCity, distance);
                secondCity.add(firsCity, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public City lookup(String name) {
        int i = hash(name);
        while (cities[i] != null) {
            if (cities[i].name.equals(name)) {
                return cities[i];
            }
            i++;
            i %= mod;
        }
        cities[i] = new City(name);
        return cities[i];
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }
}
