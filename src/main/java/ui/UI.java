package ui;

import model.Location;

import java.util.Map;

public interface UI {
    void updateDisplay(Map<String, Location> map);
}
