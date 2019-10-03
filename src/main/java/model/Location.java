package model;

import ui.UI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Location {
    private final Map<String, Location> map;
    private final UI ui;

    Location(UI ui){
        this.ui = ui;
        map = new HashMap<>();
    }

    public void addDirect(String key, Location location){
        map.put(key, location);
    }

    public Location move() {
        ui.updateDisplay(map);
        int direction = new Scanner(System.in).nextInt();
        action();
        String[] list = (String[]) map.keySet().toArray();
        return map.get(list[direction - 1]);
    }

    abstract void action();
}
