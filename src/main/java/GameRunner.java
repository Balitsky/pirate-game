import core.Core;
import model.Location;

public class GameRunner {
    public static void run(Class<? extends Core> core){
        Location current = null;
        try {
            current = core.newInstance().getHome();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        while (true){
            current = current.move();
        }
    }
}
