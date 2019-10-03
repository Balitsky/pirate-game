package ui;

import model.Location;
import java.util.Map;

public class ConsoleUI implements UI{
    public void updateDisplay(Map<String, Location> map){
        StringBuilder values = new StringBuilder();
        int i = 1;
        for (String key : map.keySet()) {
            values.append(i++).append(". ").append(map.get(key)).append("\n");
        }
        System.out.println(values.toString());
    }
}
