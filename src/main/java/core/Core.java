package core;

import model.Location;

import java.util.HashMap;
import java.util.Map;

public abstract class Core {
    private final Map<String, Location> instance;

    public Core() {
        instance = new HashMap<>();

        Provider provider = new Provider();
        registerLocations(provider);
        registerDirections(provider);
    }

    public Location getHome(){
        return instance.get(0);
    }

    public abstract void registerLocations(Provider provider);

    public abstract void registerDirections(Provider provider);

    public class Provider {

        private Provider(){}

        public void registerLocations(Class<? extends Location> location, String key) {
            try {
                instance.put(key, location.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public void registerDirections(String location, String...keys){
            Location current = instance.get(location);
            for (String key: keys){
                current.addDirect(key, instance.get(key));
            }
        }
    }
}
