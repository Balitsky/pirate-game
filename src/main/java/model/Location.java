package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Location {
    private final Map<String, Location> map;

    Location(){
        map = new HashMap<String, Location>();
    }

    private String infoDirection() {
        StringBuilder values = new StringBuilder();
        int i = 1;
        for (String key : map.keySet()) {
            values.append(i++).append(". ").append(map.get(key)).append("\n");
        }
        return values.toString();
    }

    public void addDirect(String key, Location location){
        map.put(key, location);
    }

    public Location move() {
        System.out.println(infoDirection());
        int direction = new Scanner(System.in).nextInt();
        action();
        String[] list = (String[]) map.keySet().toArray();
        return map.get(list[direction - 1]);
    }

    abstract void action();
}
