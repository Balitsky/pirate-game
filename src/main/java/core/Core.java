package core;

import model.Location;
import ui.ConsoleUI;
import ui.UI;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class Core {
    private final Map<String, Location> instance;

    private UI ui;

    public Core() {
        instance = new HashMap<>();

        Provider provider = new Provider();
        registerUI(provider);
        registerLocations(provider);
        registerDirections(provider);
    }

    public Location getHome(){
        return instance.get(0);
    }

    public abstract void registerLocations(Provider provider);

    public abstract void registerDirections(Provider provider);

    public void registerUI(Provider provider){
        provider.registerUI(ConsoleUI.class);
    }

    public class Provider {

        private Provider(){}

        public void registerLocations(Class<? extends Location> location, String key) {
            try {
                instance.put(key, location.getConstructor(UI.class).newInstance(ui));
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public void registerDirections(String location, String...keys){
            Location current = instance.get(location);
            for (String key: keys){
                current.addDirect(key, instance.get(key));
            }
        }

        public void registerUI(Class<? extends UI> ui){
            try {
                Core.this.ui = ui.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
